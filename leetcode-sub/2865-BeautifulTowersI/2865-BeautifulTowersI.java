// Last updated: 4/15/2025, 1:30:42 AM
class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length, top = -1;
        int[] stack = new int[n], PSE = new int[n], NSE = new int[n];
        Arrays.fill(PSE, -1);
        Arrays.fill(NSE, n);
        for (int i = 0; i < n; i++) {
            while (top != -1 && heights[stack[top]] > heights[i]) {
                int t = stack[top--];
                NSE[t] = i;
            }
            if (top != -1) {
                PSE[i] = stack[top];
            }
            stack[++top] = i;
        }
        long[] pre = new long[n], suf = new long[n];
        for (int i = 0; i < n; i++) {
            pre[i] = (i - PSE[i]) * (long) heights[i];
            pre[i] += PSE[i] != -1 ? pre[PSE[i]] : 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = (NSE[i] - i) * (long) heights[i];
            suf[i] += NSE[i] != n ? suf[NSE[i]] : 0;
        }
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, pre[i] + suf[i] - heights[i]);
        }
        return max;
    }
}
