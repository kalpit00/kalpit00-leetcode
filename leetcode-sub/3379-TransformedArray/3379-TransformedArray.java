// Last updated: 10/4/2025, 6:26:05 AM
class Solution {
    public int[] constructTransformedArray(int[] A) {
        int n = A.length;
        int res[] = new int[n];
        for (int i = 0; i < n; ++i) {
            res[i] = A[(i + A[i] % n + n) % n];
        }
        return res;
    }
}