// Last updated: 5/15/2025, 8:34:29 PM
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = groups.length, maxIndex = 0;
        int[] dp = new int[n], prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) { // LIS DP!!!
                if (groups[i] != groups[j] && helper(words[i], words[j]) && 
                dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            } // to backtrack from maxIndex. PRINT LIS!!!
        }
        List<String> res = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            res.add(words[i]);
        }
        Collections.reverse(res);
        return res;
    }
// function to check if only ONE character unmatches in s1, s2
    private boolean helper(String s1, String s2) {
        int m = s1.length(), n = s2.length(), count = 0;
        if (m != n) {
            return false;
        } // both must be same length else false directly
        for (int i = 0; i < m; i++) { // count if chars do not match
            count += s1.charAt(i) != s2.charAt(i) ? 1 : 0;
            if (count > 1) {
                return false;
            } // prune if more than 2 chars unmatch
        }
        return count == 1; // return true if only 1 char mismatched!
    }
}