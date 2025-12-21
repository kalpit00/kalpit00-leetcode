// Last updated: 12/20/2025, 9:05:34 PM
1class Solution {
2    public int minDeletionSize(String[] A) {
3        int N = A.length;
4        int W = A[0].length();
5        // cuts[j] is true : we don't need to check any new A[i][j] <= A[i][j+1]
6        boolean[] cuts = new boolean[N-1];
7
8        int ans = 0;
9        search: for (int j = 0; j < W; ++j) {
10            // Evaluate whether we can keep this column
11            for (int i = 0; i < N-1; ++i)
12                if (!cuts[i] && A[i].charAt(j) > A[i+1].charAt(j)) {
13                    // Can't keep the column - delete and continue
14                    ans++;
15                    continue search;
16                }
17
18            // Update 'cuts' information
19            for (int i = 0; i < N-1; ++i)
20                if (A[i].charAt(j) < A[i+1].charAt(j))
21                    cuts[i] = true;
22        }
23
24        return ans;
25    }
26}
27