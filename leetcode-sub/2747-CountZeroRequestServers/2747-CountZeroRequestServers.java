// Last updated: 5/14/2025, 11:32:48 PM
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;
        int[] map = new int[1000001];
        for (int i = 0; i < n; i++) {
            map[nums[i]] = i;
        }
        for (int[] op : operations) {
            nums[map[op[0]]] = op[1];
            map[op[1]] = map[op[0]];
        }
        return nums;
    }
}