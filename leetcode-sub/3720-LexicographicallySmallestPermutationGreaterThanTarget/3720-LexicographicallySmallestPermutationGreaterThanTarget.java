// Last updated: 8/26/2026, 9:34:55 PM
1class Solution {
2    public String lexGreaterPermutation(String s, String target) {
3        int[] cnt = new int[26];
4        for (int i = 0; i < s.length(); i++) {
5            cnt[s.charAt(i) - 'a']++;
6            cnt[target.charAt(i) - 'a']--;
7        }
8        // Try from right to left
9        char[] t = target.toCharArray();
10        for (int i = s.length() - 1; i >= 0; i--) {
11            int b = t[i] - 'a';
12            cnt[b]++; // Reversal of consumption
13            // Check if the prefix can fully match
14            if (Arrays.stream(cnt).min().getAsInt() < 0) {
15                continue;
16            }
17            // Find the smallest available character larger than b.
18            for (int j = b + 1; j < 26; j++) {
19                if (cnt[j] > 0) {
20                    cnt[j]--;
21                    t[i] = (char) ('a' + j);
22                    return new String(t, 0, i + 1) + getMinString(cnt);
23                }
24            }
25        }
26
27        return "";
28    }
29
30    // Get the lexicographically smallest string (in ascending order)
31    private String getMinString(int[] cnt) {
32        StringBuilder res = new StringBuilder();
33        for (int i = 0; i < 26; i++) {
34            res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
35        }
36        return res.toString();
37    }
38}