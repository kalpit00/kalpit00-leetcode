// Last updated: 3/31/2026, 4:13:05 PM
class Solution {
    public int minimumNumbers(int num, int k) {
        if (num == 0) return 0;
        for (int n = 1; n <= 10; n++) {
            if (n * k % 10 == num % 10 && n * k <= num) {
                return n;
            }
        }
        return -1;
    }
}