// Last updated: 5/22/2025, 8:13:29 PM
class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        Long[][] memo = new Long[n][2];
        return solve(0, n, 1, nums, k, memo);
    }

    private long solve(int i, int n, int isEven, int[] nums, int k, 
    Long[][]memo) {
        if (i == n) {
            return isEven == 1 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][isEven] != null) {
            return memo[i][isEven];
        }
        long notTake = nums[i] + solve(i + 1, n, isEven, nums, k, memo);
        long take = (nums[i] ^ k) + solve(i + 1, n, isEven ^ 1, nums, k, memo);
        return memo[i][isEven] = Math.max(take, notTake);
    }
}