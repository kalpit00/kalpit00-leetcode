// Last updated: 4/5/2025, 4:05:06 PM
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int n = nums.length, count = 1;
        int[] res = new int[n - k + 1];
        Arrays.fill(res, -1);
        for (int i = 1; i < n; i++) {
            count = nums[i] - nums[i-1] == 1 ? count + 1 : 1;
            if (count >= k) {
                res[i - k + 1] = nums[i];
            }
        }
        return res;
    }
}