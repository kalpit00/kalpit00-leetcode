// Last updated: 4/6/2025, 8:47:06 PM
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        Boolean[][] memo = new Boolean[n + 1][sum + 1];
        return helper(nums, 0, sum, memo);
    }

    public boolean helper(int[] nums, int i, int sum, Boolean[][] memo) {
        if (i >= nums.length) {
            return sum == 0;
        }
        if (memo[i][sum] != null) {
            return memo[i][sum];
        }
        boolean notTake = helper(nums, i + 1, sum, memo);
        boolean take = false;
        if (sum >= nums[i]) {
            take |= helper(nums, i + 1, sum - nums[i], memo);
        }
        return memo[i][sum] = notTake || take;
    }
}
