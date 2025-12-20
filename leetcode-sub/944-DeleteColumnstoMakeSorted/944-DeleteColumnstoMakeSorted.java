// Last updated: 12/19/2025, 8:14:04 PM
1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int m = strs[0].length(), n = strs.length, count = 0;
4        for (int j = 0; j < m; j++) {
5            for (int i = 1; i < n; i++) {
6                if (strs[i].charAt(j) < strs[i - 1].charAt(j)) {
7                    count++;
8                    break;
9                }
10            }
11        }
12        return count;
13    }
14}