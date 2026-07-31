// Last updated: 7/31/2026, 10:55:33 AM
1class Solution {
2    public int sumOfPrimesInRange(int num) {
3        int rev = helper(num), n = Math.max(num, rev), sum = 0;
4        boolean[] notPrime = new boolean[n + 1];
5        notPrime[0] = notPrime[1] = true;
6        for (int i = 2; i <= n; i++) {
7            if (!notPrime[i]) {
8                for (int j = 2; i*j <= n; j++) {
9                    notPrime[i*j] = true;
10                }
11            }
12            sum += !notPrime[i] && i >= Math.min(num, rev) ? i : 0;
13        }
14        return sum;
15    }
16    private int helper(int n) {
17        int num = 0;
18        while (n > 0) {
19            int d = n % 10;
20            num = num * 10 + d;
21            n /= 10;
22        }
23        return num;
24    }
25}