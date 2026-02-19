// Last updated: 2/19/2026, 6:44:36 PM
1class Solution {
2    public int findMaxLength(int[] nums) {
3        int n = nums.length, max = 0;
4        int[] pre0 = new int[n + 1], pre1 = new int[n + 1], 
5        arr = new int[n + 1];
6        for (int i = 1; i <= n; i++) {
7            pre0[i] = pre0[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
8            pre1[i] = pre1[i - 1] + (nums[i - 1] == 1 ? 1 : 0);
9            arr[i] = pre0[i] - pre1[i];            
10        }
11        Map<Integer, Integer> map = new HashMap<>();
12        for (int i = 0; i <= n; i++) {
13            map.putIfAbsent(arr[i], i);
14            max = Math.max(max, i - map.get(arr[i]));
15        }
16        return max;
17    }
18}