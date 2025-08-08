// Last updated: 8/8/2025, 6:01:12 PM
class Solution {
    public int countEven(int num) {
        int n = num, sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return (num - (sum % 2)) / 2;
    }
}