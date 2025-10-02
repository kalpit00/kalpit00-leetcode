// Last updated: 10/2/2025, 7:17:41 PM
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, max = 0;
        int[] pre0 = new int[n + 1], pre1 = new int[n + 1], 
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre0[i] = pre0[i - 1] + (nums[i - 1] == 0 ? 1 : 0);
            pre1[i] = pre1[i - 1] + (nums[i - 1] == 1 ? 1 : 0);
            arr[i] = pre0[i] - pre1[i];            
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            map.putIfAbsent(arr[i], i);
            max = Math.max(max, i - map.get(arr[i]));
        }
        return max;
    }
}