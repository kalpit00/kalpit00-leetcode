// Last updated: 5/20/2026, 7:42:23 PM
1class Solution {
2    public int maxFrequency(int[] nums, int k) {
3        int n = nums.length, count = 0, max = 0;
4        Set<Integer> set = new HashSet<>();
5        for (int num : nums) {
6            set.add(num);
7            count += num == k ? 1 : 0;
8        }
9        for (int x : set) {
10            if (x == k) continue;
11            max = Math.max(max, kadane(nums, x, k));
12        }
13        return count + max;
14    }
15    public int kadane(int[] nums, int x, int k) {
16        int sum = 0, max = Integer.MIN_VALUE;
17        for (int num : nums) {
18            sum += num == x ? 1 : num == k ? -1 : 0;
19            max = Math.max(max, sum);
20            sum = sum < 0 ? 0 : sum;
21        }
22        return max;
23    }
24}