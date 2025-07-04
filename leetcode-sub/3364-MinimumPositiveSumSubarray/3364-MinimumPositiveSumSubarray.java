// Last updated: 7/4/2025, 12:49:53 PM
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        boolean val = false;
        int min = Integer.MAX_VALUE;
        for (int k = l; k <= r; k++) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums.get(i);
            }
            if (sum > 0) {
                min = Math.min(min, sum);
                val = true;
            }
            for (int i = k; i < nums.size(); i++) {
                sum = sum + nums.get(i) - nums.get(i - k);
                if (sum > 0) {
                    min = Math.min(min, sum);
                    val = true;
                }
            }
        }
        return val ? min : -1;
    }
}