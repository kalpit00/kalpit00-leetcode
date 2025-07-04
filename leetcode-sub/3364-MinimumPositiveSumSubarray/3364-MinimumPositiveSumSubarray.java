// Last updated: 7/4/2025, 12:47:36 PM
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE, n = nums.size();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int k = j - i + 1; // windowLen
                if (k > r) break;
                if (l <= k && k <= r) {
                    min = sum > 0 ? Math.min(min, sum) : min;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}