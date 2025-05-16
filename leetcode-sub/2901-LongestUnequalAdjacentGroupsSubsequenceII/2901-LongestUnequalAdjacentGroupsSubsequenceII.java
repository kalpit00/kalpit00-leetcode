// Last updated: 5/15/2025, 8:22:36 PM
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length, maxIndex = 0;
        int[] dp = new int[n], prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && check(words[i], words[j]) && 
                dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }

    private boolean check(String s1, String s2) {
        int m = s1.length(), n = s2.length(), count = 0;
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}