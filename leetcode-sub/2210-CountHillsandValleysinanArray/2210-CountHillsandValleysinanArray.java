// Last updated: 7/26/2025, 9:17:09 PM
class Solution {
    public int countHillValley(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;            
            int l = i - 1, r = i + 1;
            while (l > 0 && nums[i] == nums[l]) {
                l--;
            }
            while (r < n - 1 && nums[i] == nums[r]) {
                r++;
            }
            count += (nums[i] > nums[l] && nums[i] > nums[r]) || 
            (nums[i] < nums[l] && nums[i] < nums[r]) ? 1 : 0;
        }
        return count;
    }
}