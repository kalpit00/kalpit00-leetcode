// Last updated: 7/27/2026, 8:22:31 PM
1class Solution {
2    public String smallestPalindrome(String s) {
3        int[] map = new int[26];
4        for (char c : s.toCharArray()) {
5            map[c - 'a']++;
6        }
7        int n = s.length(), i = 0, j = n - 1;
8        char[] res = new char[n];
9        for (int k = 0; k < 26; k++) {
10            if (map[k] % 2 == 1) {
11                res[n / 2] = (char) (k + 'a');
12                map[k]--;
13            }
14            while (map[k] > 0) {
15                res[i++] = (char) (k + 'a');
16                res[j--] = (char) (k + 'a');
17                map[k] -= 2;
18            }
19        }
20        return String.valueOf(res);
21    }
22}