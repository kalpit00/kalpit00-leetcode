// Last updated: 4/17/2025, 9:34:01 PM
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1"; // base case of recursion
        }
        String last = countAndSay(n - 1);
        int m = last.length(), i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < m) {
            int streak = 1;
            while (i < m - 1 && last.charAt(i) == last.charAt(i + 1)) {
                streak++;
                i++;
            }
            sb.append(streak);
            sb.append(last.charAt(i++));
        }
        return sb.toString();
    }
}