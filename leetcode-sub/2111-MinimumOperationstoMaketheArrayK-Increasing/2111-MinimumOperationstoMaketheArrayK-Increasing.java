// Last updated: 2/12/2026, 9:21:01 PM
1class Solution {
2    public int kIncreasing(int[] arr, int k) {
3        int n = arr.length, res = 0;
4        for (int i = 0; i < k; i++) {
5            List<Integer> list = new ArrayList<>();
6            for (int j = i; j < n; j += k) {
7                list.add(arr[j]);
8            }
9            Integer[] nums = list.toArray(new Integer[0]);
10            int m = nums.length;
11            res += m - lengthOfLIS(nums);
12        }
13        return res;
14    }
15    public int lengthOfLIS(Integer[] nums) {            
16        int[] dp = new int[nums.length];
17        int len = 0;
18        for (int x : nums) {
19            int i = Arrays.binarySearch(dp, 0, len, x);
20            if (i < 0) {
21                i = -(i + 1);
22            } else {
23                i = Arrays.binarySearch(dp, i, len, x + 1);
24                i = i < 0 ? -(i + 1) : i;
25            }
26            dp[i] = x;
27            len += (i == len) ? 1 : 0;
28        }
29        return len;
30    }
31}