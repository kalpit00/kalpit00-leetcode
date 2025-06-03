// Last updated: 6/3/2025, 3:09:37 AM
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1, max = nums[0], min = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (max - min > k) {
                count++;
                max = num;
                min = num;
            }
        }
        return count;
    }
}