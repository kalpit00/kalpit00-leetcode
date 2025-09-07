// Last updated: 9/6/2025, 9:00:58 PM
class Solution {
    public int[] sumZero(int n) {
        int sum = 0;
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;
            sum += i + 1;
        }
        res[n - 1] = -sum;
        return res;
    }
}