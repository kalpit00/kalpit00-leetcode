// Last updated: 5/12/2025, 9:01:56 PM
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        int count = 0, mod = 1000000007;
        int[] prev = new int[26];
        for (char ch : s.toCharArray()) {
            prev[ch - 'a']++;
        }
        for (int k = 0; k < t; k++) {
            int[] curr = new int[26];
            curr[0] = prev[25];
            curr[1] = (prev[25] + prev[0]) % mod;
            for (int i = 2; i < 26; i++) {
                curr[i] = prev[i - 1];
            }
            prev = curr;
        }
        for (int i = 0; i < 26; i++) {
            count = (count + prev[i]) % mod;
        }
        return count;
    }
}