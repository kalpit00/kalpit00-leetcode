// Last updated: 4/28/2026, 3:37:04 PM
1class Solution {
2    public int[] evenOddBit(int num) {
3        char[] s = Integer.toBinaryString(num).toCharArray();
4        int n = s.length, even = 0, odd = 0;
5        for (int i = n - 1; i >= 0; i--) {
6            even += (n - i - 1) % 2 == 0 && s[i] == '1' ? 1 : 0;
7            odd += (n - i - 1) % 2 == 1 && s[i] == '1' ? 1 : 0;
8        }
9        return new int[]{even, odd};
10    }
11}