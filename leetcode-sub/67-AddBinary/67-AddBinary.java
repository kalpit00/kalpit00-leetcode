// Last updated: 2/14/2026, 7:34:16 PM
1class Solution {
2    public String addBinary(String a, String b) {
3        StringBuilder sb = new StringBuilder();
4        char[] l1 = a.toCharArray(), l2 = b.toCharArray();
5        int m = l1.length, n = l2.length;
6        int i = m - 1, j = n - 1, carry = 0;
7        while (i >= 0 || j >= 0 || carry != 0) {
8            int x = i >= 0 ? l1[i--] - '0' : 0;
9            int y = j >= 0 ? l2[j--] - '0' : 0;
10            int sum = x + y + carry;
11            sb.append(sum % 2);
12            carry = sum / 2;
13        }
14        return sb.reverse().toString();
15    }
16}
17