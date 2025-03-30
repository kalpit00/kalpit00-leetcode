// Last updated: 3/30/2025, 7:19:31 PM
class Solution {
    public String makeFancyString(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n = chars.length, i = 0;
        while (i < n) {
            int streak = 1;
            char c = chars[i];
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                streak++;
                i++;
            }
            sb.append(c);
            if (streak > 1) {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}