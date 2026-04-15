// Last updated: 4/15/2026, 3:26:43 AM
1class Solution {
2    public int closestTarget(String[] words, String target, int startIndex) {
3        int n = words.length, i = startIndex, j = startIndex + n, k = 0;
4        while (k <= n / 2) {
5            if (words[i % n].equals(target) || words[j % n].equals(target)) {
6                return k;
7            }
8            i++;
9            j--;
10            k++;
11        }
12        return -1;
13    }
14}