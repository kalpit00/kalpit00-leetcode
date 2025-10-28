// Last updated: 10/27/2025, 9:13:53 PM
class Solution {
    public int countValidSelections(int[] nums) {

        int count = 0, len = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        int halfSum = 0;

        for (int i = 0; i < len; i++) {
            halfSum += nums[i];
            if (nums[i] == 0) {

                if (2 * halfSum == sum) {
                    count += 2;
                } else if (Math.abs(sum - 2*halfSum) == 1) {
                    count++;
                } 
            }
        }
        return count;
    }
}