// Last updated: 5/11/2025, 6:47:32 AM
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n - 1; i++) {
            if (arr[i - 1] % 2 != 0 && arr[i] % 2 != 0 && arr[i+1] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}