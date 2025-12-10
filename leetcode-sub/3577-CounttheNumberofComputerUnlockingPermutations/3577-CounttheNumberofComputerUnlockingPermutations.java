// Last updated: 12/9/2025, 7:53:27 PM
1class Solution {
2    int mod = 1000000007;
3    public int countPermutations(int[] nums) {
4        int n = nums.length;
5        for (int i = 1; i < n; i++) {
6            if (nums[i] <= nums[0]) {
7                return 0;
8            }
9        }
10        return (int) factorial(n - 1);
11    }
12    private long factorial(int n) {
13        long fact = 1;
14        for (int i = 2; i <= n; i++) {
15            fact *= i;
16            fact %= mod;
17        }
18        return fact;
19    }
20}