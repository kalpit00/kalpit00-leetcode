// Last updated: 7/24/2025, 2:33:57 PM
class Solution {
    public long maximumSum(List<Integer> nums) {
        long max = 0;
        int n = nums.size();
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 1; i * j * j <= n; j++) {
                sum += nums.get(i * j * j - 1);
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}