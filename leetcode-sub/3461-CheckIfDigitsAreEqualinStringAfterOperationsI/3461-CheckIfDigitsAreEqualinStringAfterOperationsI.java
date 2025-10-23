// Last updated: 10/22/2025, 9:05:17 PM
class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                temp.append(((s.charAt(i) - '0') + (s.charAt(i + 1) - '0')) % 10);
            }
            s = temp.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}