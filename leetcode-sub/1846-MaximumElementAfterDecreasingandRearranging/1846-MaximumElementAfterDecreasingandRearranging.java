// Last updated: 6/27/2026, 11:31:31 PM
1class Solution {
2    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
3        int n = arr.length;
4        int[] counts = new int[n + 1];
5        
6        for (int num : arr) {
7            counts[Math.min(num, n)]++;
8        }
9        
10        int ans = 1;
11        for (int num = 2; num <= n; num++) {
12            ans = Math.min(ans + counts[num], num);
13        }
14        
15        return ans;
16    }
17}