// Last updated: 11/14/2026, 11:13:56 PM
1class Solution {
2    public int numOfSubarrays(int[] arr) {
3        int n = arr.length, mod = 1000000007;
4        long count = 0, sum = 0;
5        for (int num : arr) {
6            sum += num;
7            count += sum % 2 == 1 ? 1 : 0;
8        }
9        count += (n - count) * count;
10        return (int) (count % mod);
11    }
12}