// Last updated: 8/8/2026, 12:50:56 AM
1class Solution {
2
3    public int[] validSequence(String word1, String word2) {
4        int n = word1.length(),
5            m = word2.length();
6        int[] last = new int[m];
7        Arrays.fill(last, -1);
8        int j = m - 1;
9        for (int i = n - 1; i >= 0; --i) {
10            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
11                last[j] = i;
12                j -= 1;
13            }
14        }
15        int[] res = new int[m];
16        int skip = 0;
17        j = 0;
18        for (int i = 0; i < n; ++i) {
19            if (j == m) break;
20            if (
21                word1.charAt(i) == word2.charAt(j) ||
22                (skip == 0 && (j == m - 1 || i < last[j + 1]))
23            ) {
24                skip += word1.charAt(i) != word2.charAt(j) ? 1 : 0;
25                res[j] = i;
26                j += 1;
27            }
28        }
29        return j == m ? res : new int[0];
30    }
31}