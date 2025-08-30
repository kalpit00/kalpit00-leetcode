// Last updated: 8/30/2025, 1:11:10 AM
class Solution {
   public static long validSubstringCount(String word1, String word2) {
        int[] v = new int[26];
        for (char c : word2.toCharArray()) {
            v[c - 'a']++;
        }

        int[] cnt = new int[26];
        int start = 0;
        int k = word2.length();
        long count = 0;

        for (int i = 0; i < word1.length(); i++) {
            char curr = word1.charAt(i);
            if (v[curr - 'a'] > 0) {
                if (cnt[curr - 'a'] < v[curr - 'a']) {
                    k--;
                }
            }

            cnt[curr - 'a']++;

            while (k == 0) {
                count += word1.length() - i;
                char pre = word1.charAt(start);
                cnt[pre - 'a']--;
                if (v[pre - 'a'] > 0 && cnt[pre - 'a'] < v[pre - 'a']) {
                    k++;
                }
                start++;
            }
        }

        return count;
    }
}