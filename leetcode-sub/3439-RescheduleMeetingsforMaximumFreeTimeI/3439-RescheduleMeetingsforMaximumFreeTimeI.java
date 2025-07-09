// Last updated: 7/8/2025, 11:03:04 PM
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length, sum = 0, max = 0;
        for (int i = 0; i < k; i++) {
            sum += endTime[i] - startTime[i];
        }
        int left = 0, right = (k == n) ? eventTime : startTime[k];
        max = Math.max(max, right - left - sum);
        for (int i = k; i < n; i++) {
            int incoming = endTime[i] - startTime[i];
            int outgoing = endTime[i - k] - startTime[i - k];
            sum += incoming - outgoing;
            left = endTime[i - k];
            right = (i == n - 1) ? eventTime : startTime[i + 1];
            max = Math.max(max, right - left - sum);
        }
        return max;
    }
}
