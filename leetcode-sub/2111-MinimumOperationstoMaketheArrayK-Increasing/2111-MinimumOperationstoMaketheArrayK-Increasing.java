// Last updated: 2/12/2026, 9:16:33 PM
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
19            int i = upperBound(dp, len, x);
20            i = i < 0 ? -(i + 1) : i;
21            dp[i] = x;
22            len += (i == len) ? 1 : 0;
23        }
24        return len;
25    }
26    private int upperBound(int[] dp, int n, int x) {
27        int start = 0, end = n, ans = n;
28        while (start <= end) {
29            int mid = start + (end - start) / 2;
30            if (dp[mid] > x) {
31                ans = mid;
32                end = mid - 1;
33            }                
34            else {
35                start = mid + 1;
36            }
37        }
38        return ans;
39    }
40}