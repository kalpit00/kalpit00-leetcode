// Last updated: 5/31/2025, 9:36:14 PM
class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length, sum = nums[0] + nums[1], count = 1;
        for (int i = 2; i < n - 1; i += 2) {
            if (nums[i] + nums[i + 1] == sum) {
                count++;
            }
            else {
                return count;
            }
        }
        return count;
    }
}