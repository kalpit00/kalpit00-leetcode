// Last updated: 7/20/2025, 10:44:15 PM
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
            } // append 'c' twice if streak > 1, or append only once
            sb.append(c);
            if (streak > 1) {
                sb.append(c);
            }
            i++;
        }
        return sb.toString();
    }
}