// Last updated: 6/5/2025, 5:12:58 PM
public class Solution {
    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        long result = 1;
        int size = nums.length;
        int count = 0;

        for (int i = 0; i < size; ++i) {
            if (result * nums[i] > 0 || (i + 1 < size && nums[i + 1] < 0)) {
                result *= nums[i];
                count++;
            }
        }

        return count > 0 ? result : nums[size - 1];
    }
}
