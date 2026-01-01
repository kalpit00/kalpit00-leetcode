// Last updated: 12/31/2025, 11:33:46 PM
1class Solution {
2    public int[] plusOne(int[] digits) {
3        int n = digits.length;
4        for (int i = n - 1; i >= 0; i--) {
5            if (digits[i] != 9) {
6                digits[i]++;
7                break;
8            } 
9            else {
10                digits[i] = 0;
11            }
12        }
13        if (digits[0] == 0) {
14            int[] res = new int[n+1];
15            res[0] = 1;
16            return res;
17        }
18        return digits;
19    }
20}