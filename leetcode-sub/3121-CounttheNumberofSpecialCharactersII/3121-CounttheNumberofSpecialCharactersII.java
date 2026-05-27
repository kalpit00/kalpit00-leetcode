// Last updated: 5/26/2026, 8:10:46 PM
1class Solution {
2    public int numberOfSpecialChars(String word) {
3        int[] firstUpper = new int[26];
4        int[] lastLower = new int[26];
5
6        Arrays.fill(firstUpper, Integer.MAX_VALUE);
7        Arrays.fill(lastLower, -1);
8
9        char[] s = word.toCharArray();
10
11        for (int i = 0; i < s.length; i++) {
12            char c = s[i];
13
14            if (c >= 'a' && c <= 'z') {
15                lastLower[c - 'a'] = i;
16            } else {
17                firstUpper[c - 'A'] = Math.min(firstUpper[c - 'A'], i);
18            }
19        }
20
21        int count = 0;
22
23        for (int i = 0; i < 26; i++) {
24            if (lastLower[i] != -1 && firstUpper[i] != Integer.MAX_VALUE) {
25                if (lastLower[i] < firstUpper[i]) count++;
26            }
27        }
28
29        return count;
30    }
31}