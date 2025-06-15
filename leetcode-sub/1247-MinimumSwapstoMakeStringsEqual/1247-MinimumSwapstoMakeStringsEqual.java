// Last updated: 6/15/2025, 2:02:52 AM
class Solution {
    public int minimumSwap(String s1, String s2) {
        int x1 = 0, x2 = 0, y1 = 0, y2 = 0, n = s1.length();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 == c2) continue;
            x1 += c1 == 'x' ? 1 : 0;
            x2 += c2 == 'x' ? 1 : 0;
            y1 += c1 == 'y' ? 1 : 0;
            y2 += c2 == 'y' ? 1 : 0;
        }
        if ((x1 + x2) % 2 != 0 || (y1 + y2) % 2 != 0) {
            return -1;
        }
        return x1 / 2 + y1 / 2 + (x1 % 2) * 2;
    }
}