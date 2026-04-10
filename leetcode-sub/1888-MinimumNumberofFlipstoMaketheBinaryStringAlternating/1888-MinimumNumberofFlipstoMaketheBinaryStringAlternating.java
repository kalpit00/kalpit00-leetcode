// Last updated: 4/10/2026, 4:41:26 PM
1class Solution {
2    public int minimumFlips(int n) {
3        char[] s = Integer.toBinaryString(n).toCharArray();
4        char[] rev = s.clone();
5        reverse(rev);
6        int count = 0;
7        for (int i = 0; i < s.length; i++) {
8            count += s[i] != rev[i] ? 1 : 0;
9        }
10        return count;
11    }
12    private void reverse(char[] s) {
13        int i = 0, j = s.length - 1;
14        while (i < j) {
15            char temp = s[i];
16            s[i] = s[j];
17            s[j] = temp;
18            i++;
19            j--;
20        }
21    }
22}