// Last updated: 11/15/2025, 11:50:32 PM
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length, max = 0;
        for (int i = 0; i < n; i++) {
            int m = 1; // m = streak length
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                i++;
                m++;
            }
            max = Math.max(max, m);
        }
        return max;
    }
}