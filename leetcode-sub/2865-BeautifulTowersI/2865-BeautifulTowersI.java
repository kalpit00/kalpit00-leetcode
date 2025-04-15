// Last updated: 4/15/2025, 3:17:53 AM
class Solution {
    public boolean validMountainArray(int[] nums) {
        int n = nums.length, i = 0, j = n - 1;
        while (i < n - 2 && nums[i] < nums[i + 1]) {
            i++;
        }
        while (j > 1 && nums[j] < nums[j - 1]) {
            j--;
        }
        return n < 3 ? false : i == j;
    }
}