// Last updated: 12/3/2025, 9:42:32 PM
1class Solution {
2    public int countCollisions(String directions) {
3        char[] s = directions.toCharArray();
4        int count = 0, n = s.length, l = 0, r = n - 1;
5        while (l < n && s[l] == 'L') {
6            l++;
7        }
8        while (r >= l && s[r] == 'R') {
9            r--;
10        }
11        for (int i = l; i <= r; i++) {
12            count += s[i] != 'S' ? 1 : 0;
13        }
14        return count;
15    }
16}