// Last updated: 9/16/2025, 5:23:29 PM
class Solution {
    public int minimumAverageDifference(int[] arr) {
        int n = arr.length, res = 0;
        long min = Long.MAX_VALUE;
        long[] pre = new long[n], suf = new long[n];
        pre[0] = arr[0];
        suf[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + arr[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] + arr[i];
        }
        for (int i = 0; i < n; i++) {
            long sufAvg = i == n - 1 ? 0 : suf[i + 1] / (n - i - 1);
            long preAvg = pre[i] / (i + 1);
            long diff = Math.abs(preAvg - sufAvg);
            if (diff < min) {
                min = diff;
                res = i;
            }
        }
        return res;
    }
}