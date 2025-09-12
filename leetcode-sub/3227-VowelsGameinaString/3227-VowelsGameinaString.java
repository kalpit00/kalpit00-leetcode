// Last updated: 9/11/2025, 8:41:56 PM
class Solution {
    public boolean doesAliceWin(String s) {
        int n = s.length();
        for (int i = 0; i <= n / 2; i++) {
            char ch = s.charAt(i), c = s.charAt(n - i - 1);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
        }
        return false;
    }
}