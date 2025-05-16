// Last updated: 5/16/2025, 10:27:29 AM
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                count++;
                if (count > 1) {
                    return false;
                } 
                if (i == 1 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } 
                else {
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }
}
