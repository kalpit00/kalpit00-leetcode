// Last updated: 4/16/2025, 8:43:08 PM
class Solution {
    public int countPairs(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                count += (nums[i] == nums[j]) && ((i * j) % k == 0) ? 1 : 0;
            }
        }
        return count;
    }
}