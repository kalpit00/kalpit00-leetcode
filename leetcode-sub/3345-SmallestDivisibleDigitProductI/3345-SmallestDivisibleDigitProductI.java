// Last updated: 6/19/2025, 2:58:55 AM
class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while (true) {
            int prod = 1;
            int num = i;
            while (num > 0) {
                prod *= num % 10;
                num /= 10;
            }
            if (prod % t == 0) {
                return i;
            }
            i++;
        }
    }
}