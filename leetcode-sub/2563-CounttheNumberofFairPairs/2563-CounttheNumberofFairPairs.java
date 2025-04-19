// Last updated: 4/18/2025, 8:44:43 PM
class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return helper(nums, upper) - helper(nums, lower - 1);
    }
    public long helper(int[] nums, int val) {
        long count = 0;
        int n = nums.length, i = 0, j = n - 1;
        while (i < j) {
            while (i < j && nums[i] + nums[j] > val) {
                j--;
            }
            count += j - i;
            i++;
        }       
        return count;        
    }
}