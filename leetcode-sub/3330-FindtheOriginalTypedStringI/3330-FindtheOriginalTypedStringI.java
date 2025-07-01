// Last updated: 7/1/2025, 2:12:38 AM
class Solution {
    public int possibleStringCount(String word) {
        char[] s = word.toCharArray();
        int n = s.length, count = 1, i = 0;
        while (i < n) {
            int streak = 1;
            while (i < n - 1 && s[i] == s[i + 1]) {
                streak++;
                i++;
            }
            count += streak - 1;
            i++;
        }
        return count;
    }
}