// Last updated: 5/13/2025, 10:37:34 PM
class Solution {
    public long maxProduct(String s) {
        s = "," + s + ".";
        int[] p = manacher(s);
        int n = s.length();
        int[] pre = new int[n], suf = new int[n];
        pre[0] = 1;
        suf[n - 1] = 1;
        for (int i = 1; i < n - 1; i++) {
            pre[i] = pre[i - 1];
            if (p[i - pre[i] / 2 - 1] > pre[i] / 2) {
                pre[i] += 2;
            }
        }
        for (int i = n - 2; i > 0; i--) {
            suf[i] = suf[i + 1];
            if (p[i + suf[i] / 2 + 1] > suf[i] / 2) {
                suf[i] += 2;
            }
        }
        long max = 0;
        for (int i = 2; i < n - 1; i++) {
            max = Math.max(max, (long) pre[i - 1] * suf[i]);
        }
        return max;
    }

    private int[] manacher(String s) {
        int n = s.length();
        int[] p = new int[n];
        int center = 0, maxRight = 0;
        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * center - i;
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            while (s.charAt(i - p[i] - 1) == s.charAt(i + p[i] + 1)) {
                p[i]++;
            }
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
        }
        return p;
    }
}
