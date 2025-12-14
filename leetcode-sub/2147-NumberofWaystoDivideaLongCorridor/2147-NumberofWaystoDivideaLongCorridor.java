// Last updated: 12/13/2025, 9:14:25 PM
1class Solution {
2    public int numberOfWays(String corridor) {
3        char[] s = corridor.toCharArray();
4        int mod = 1000000007, seats = 0, n = s.length;
5        long count = 1;
6        Integer prev = null;
7        for (int i = 0; i < n; i++) {
8            // If two seats, then this is the last S in the section            
9            if (s[i] == 'S') {
10                seats += 1;
11                if (seats == 2) {
12                    prev = i;
13                    seats = 0;
14                }
15                // If one seat, then this is the first S in the section
16                else if (seats == 1 && prev != null) {
17                    count *= (i - prev);
18                    count %= mod;
19                } // Compute product of non-paired neighbors
20            }
21        }
22        if (seats == 1 || prev == null) {
23            return 0; // If odd seats, or zero seats
24        }
25        return (int) count;
26    }
27}