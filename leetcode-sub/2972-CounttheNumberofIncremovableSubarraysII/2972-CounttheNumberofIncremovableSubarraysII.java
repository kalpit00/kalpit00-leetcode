// Last updated: 5/5/2025, 12:54:33 PM
class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n - 1 && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return 1L * n * (n + 1) / 2;
        }
        long res = i + 2;
        for (int j = n - 1; j >= 0; j--) {
            if (j < n - 1 && nums[j] >= nums[j + 1]) {
                break;
            }
            while (i >= 0 && nums[i] >= nums[j]) {
                i--;
            }
            res += i + 2;
        }
        return res;
    }
}