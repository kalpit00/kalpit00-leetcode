// Last updated: 9/6/2025, 9:04:15 PM
class Solution {
    public int[] sumZero(int n) {
        int sum = 0;
        int[] res = new int[n];
        for (int i = 0; i < n / 2; i++) {
            res[i] = i + 1;
            res[n - i - 1] = -(i + 1);
        }
        // res[n / 2] = 0; // redudant as int[] have 0s by default
        return res;
    }
}