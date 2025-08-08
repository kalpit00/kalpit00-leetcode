// Last updated: 8/8/2025, 5:59:20 PM
class Solution {
    public int countEven(int num) {
        int n = num, sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum % 2 == 0 ? num / 2 : (num - 1) / 2;
    }
}