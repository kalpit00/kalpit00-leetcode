// Last updated: 5/26/2025, 8:20:37 PM
class Solution {
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            }
            else {
                num2 += i;
            }
        }
        return num1 - num2;
    }
}