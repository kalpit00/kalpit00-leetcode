// Last updated: 5/21/2025, 2:50:18 PM
class Solution {
    public String smallestPalindrome(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int n = s.length(), i = 0, j = n - 1;
        char[] res = new char[n];
        for (int k = 0; k < 26; k++) {
            if (map[k] % 2 == 1) {
                res[n / 2] = (char) (k + 'a');
                map[k]--;
            }
            while (map[k] > 0) {
                res[i++] = (char) (k + 'a');
                res[j--] = (char) (k + 'a');
                map[k] -= 2;
            }
        }
        return String.valueOf(res);
    }
}