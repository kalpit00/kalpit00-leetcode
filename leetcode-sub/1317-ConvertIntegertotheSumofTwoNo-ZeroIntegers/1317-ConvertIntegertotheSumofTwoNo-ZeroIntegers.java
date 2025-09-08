// Last updated: 9/7/2025, 8:26:30 PM
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int i = 1, j = n - 1;
        while (i <= j) {
            if (helper(i) && helper(j)) {
                return new int[]{i, j};
            }
            i++;
            j--;
        }
        return new int[2];
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