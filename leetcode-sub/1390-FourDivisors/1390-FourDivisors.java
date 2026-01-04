// Last updated: 1/4/2026, 5:09:35 AM
1class Solution {
2    public int sumFourDivisors(int[] nums) {
3        int sum = 0;
4        for (int num : nums) {
5            sum += helper(num);
6        }
7        return sum;
8    }
9
10    private int helper(int n) {
11        int d1 = 0, d2 = 0;
12        for (int i = 2; i * i <= n; i++) {
13            if (n % i == 0) {
14                if (d1 == 0) {
15                    d1 = i;
16                    d2 = n / i;
17                } 
18                else {
19                    return 0;
20                }
21            }
22        }
23        if (d1 == 0) return 0;
24        if (d1 == d2) return 0;
25        return 1 + n + d1 + d2;
26    }
27}