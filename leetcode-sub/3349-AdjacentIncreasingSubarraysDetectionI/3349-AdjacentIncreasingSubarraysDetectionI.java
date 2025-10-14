// Last updated: 10/13/2025, 8:12:45 PM
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;
        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && 
            isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }
        return false;
    }
    public boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false;
        }
        return true;
    }
}