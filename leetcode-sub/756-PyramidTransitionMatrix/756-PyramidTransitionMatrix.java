// Last updated: 12/28/2025, 11:50:45 PM
1class Solution {
2    int[][] T;
3    Set<Long> seen;
4
5    public boolean pyramidTransition(String bottom, List<String> allowed) {
6        T = new int[7][7];
7        for (String a: allowed)
8            T[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');
9
10        seen = new HashSet();
11        int N = bottom.length();
12        int[][] A = new int[N][N];
13        int t = 0;
14        for (char c: bottom.toCharArray())
15            A[N-1][t++] = c - 'A';
16        return solve(A, 0, N-1, 0);
17    }
18
19    //A[i] - the ith row of the pyramid
20    //R - integer representing the current row of the pyramid
21    //N - length of current row we are calculating
22    //i - index of how far in the current row we are calculating
23    //Returns true iff pyramid can be built
24    public boolean solve(int[][] A, long R, int N, int i) {
25        if (N == 1 && i == 1) { // If successfully placed entire pyramid
26            return true;
27        } else if (i == N) {
28            if (seen.contains(R)) return false; // If we've already tried this row, give up
29            seen.add(R); // Add row to cache
30            return solve(A, 0, N-1, 0); // Calculate next row
31        } else {
32            // w's jth bit is true iff block #j could be
33            // a parent of A[N][i] and A[N][i+1]
34            int w = T[A[N][i]][A[N][i+1]];
35            // for each set bit in w...
36            for (int b = 0; b < 7; ++b) if (((w >> b) & 1) != 0) {
37                A[N-1][i] = b; //set parent to be equal to block #b
38                //If rest of pyramid can be built, return true
39                //R represents current row, now with ith bit set to b+1
40                // in base 8.
41                if (solve(A, R * 8 + (b+1), N, i+1)) return true;
42            }
43            return false;
44        }
45    }
46}