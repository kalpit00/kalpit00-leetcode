// Last updated: 2/19/2026, 6:50:19 PM
1class Solution {
2    public int findMaxLength(int[] nums) {
3        int n = nums.length, max = 0, sum = 0;
4        int[] arr = new int[n + 1];
5        for (int i = 1; i <= n; i++) {
6            sum += nums[i - 1];
7            arr[i] = i - 2 * sum;
8        }
9        Map<Integer, Integer> map = new HashMap<>();
10        for (int i = 0; i <= n; i++) {
11            map.putIfAbsent(arr[i], i); // putIfabsent is important!!
12            max = Math.max(max, i - map.get(arr[i]));
13        }
14        return max;
15    }
16}