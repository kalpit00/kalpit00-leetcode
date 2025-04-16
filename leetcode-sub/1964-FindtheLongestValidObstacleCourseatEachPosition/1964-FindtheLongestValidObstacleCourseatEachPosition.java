// Last updated: 4/16/2025, 2:47:13 AM
class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] nums) {
        int n = nums.length, len = 0;
        int[] lis = new int[n], dp = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = upperBound(dp, len, nums[i]);
            dp[idx] = nums[i];
            len += (idx == len) ? 1 : 0;
            lis[i] = idx + 1;
        }
        return lis;
    }

    private int upperBound(int[] dp, int n, int x) {
        int start = 0, end = n, ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] > x) {
                ans = mid;
                end = mid - 1;
            }                
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
