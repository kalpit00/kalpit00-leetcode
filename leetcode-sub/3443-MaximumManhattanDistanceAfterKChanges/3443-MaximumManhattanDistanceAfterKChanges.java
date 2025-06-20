// Last updated: 6/19/2025, 8:06:38 PM
class Solution {
    public int maxDistance(String str, int k) {
        int n = 0, s = 0, e = 0, w = 0, max = 0;
        for (char c : str.toCharArray()) {
            n += c == 'N' ? 1 : 0;
            s += c == 'S' ? 1 : 0;
            e += c == 'E' ? 1 : 0;
            w += c == 'W' ? 1 : 0;
            int y = Math.min(k, Math.min(n, s));
            int x = Math.min(k - y, Math.min(w, e));
            max = Math.max(max, Math.abs(n - s) + Math.abs(w - e) + 2*(x + y));
        }
        return max;
    }
}