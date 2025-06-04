// Last updated: 6/3/2025, 8:07:00 PM
class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length(), m = n - numFriends + 1;
        String min = "", curr = "";
        for (int i = 0; i < n; ++i) {
            curr = word.substring(i, Math.min(i + m, n));
            if (min.compareTo(curr) < 0) {
                min = curr;
            }
        }
        return min;
    }
}