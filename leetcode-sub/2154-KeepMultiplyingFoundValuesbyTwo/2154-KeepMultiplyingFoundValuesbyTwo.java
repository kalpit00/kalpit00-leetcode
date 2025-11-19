// Last updated: 11/18/2025, 10:05:00 PM
class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] set = new boolean[1001];
        for (int num : nums) {
            set[num] = true;
        }
        while (original <= 1000 && set[original]) {
            original *= 2;
        }
        return original;
    }
}