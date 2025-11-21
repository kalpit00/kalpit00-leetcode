// Last updated: 11/21/2025, 5:06:49 AM
class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] arr = s.toCharArray();
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        int n = arr.length, count = 0;
        for (int i = 0; i < n; i++) {
            int c = arr[i] - 'a';
            last[c] = i;
            first[c] = first[c] == -1 ? i : first[c];
        }
        for (int i = 0; i < 26; i++) {
            count += first[i] < last[i] ? 
            helper(arr, first[i] + 1, last[i] - 1) : 0;
        }
        return count;
    } // count distinct chars in s(i .. j)
    private int helper(char[] s, int i, int j) {
        int count = 0;
        boolean[] map = new boolean[26];
        for (i = i; i <= j; i++) {
            count += !map[s[i] - 'a'] ? 1 : 0;
            map[s[i] - 'a'] = true;
        }
        return count;
    }
}