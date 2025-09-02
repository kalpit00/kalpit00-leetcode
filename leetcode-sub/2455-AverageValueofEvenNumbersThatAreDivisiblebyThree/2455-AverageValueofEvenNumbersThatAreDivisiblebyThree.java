// Last updated: 9/2/2025, 5:35:25 PM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            if (helper(i) && helper(j)) {
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    private boolean helper(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}