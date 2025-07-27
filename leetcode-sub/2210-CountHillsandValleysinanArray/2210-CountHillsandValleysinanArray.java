// Last updated: 7/26/2025, 9:16:24 PM
class Solution {
    public int countHillValley(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;            
            int l = i - 1, r = i + 1;
            boolean isHillLeft = false, isHillRight = false;
            boolean isValleyLeft = false, isValleyRight = false;
            while (l > 0 && nums[i] == nums[l]) {
                l--;
            }
            while (r < n - 1 && nums[i] == nums[r]) {
                r++;
            }
            isHillLeft = nums[i] > nums[l];            
            isHillRight = nums[i] > nums[r];
            isValleyLeft = nums[i] < nums[l];            
            isValleyRight = nums[i] < nums[r];
            count += (isHillLeft && isHillRight) || 
            (isValleyLeft && isValleyRight) ? 1 : 0;
        }
        return count;
    }
}