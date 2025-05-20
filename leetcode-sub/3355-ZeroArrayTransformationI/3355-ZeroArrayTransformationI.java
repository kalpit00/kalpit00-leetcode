// Last updated: 5/19/2025, 8:13:31 PM
class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        return lineSweep(nums, queries, queries.length);
    }
    private boolean lineSweep(int[] nums, int[][] queries, int k) {
        int m = queries.length, n = nums.length, sum = 0;
        int[] count = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int start = queries[i][0], end = queries[i][1];
            int val = 1;
            count[start] += val;
            count[end + 1] -= val;
        }
        for (int i = 0 ; i < n; i++) {
            sum += count[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }
}