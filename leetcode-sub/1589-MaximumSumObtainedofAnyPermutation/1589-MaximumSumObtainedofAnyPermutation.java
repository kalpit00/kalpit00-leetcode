// Last updated: 8/8/2025, 5:56:53 PM
class Solution {
    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int n = i, sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            count += sum % 2 == 0 ? 1 : 0;
        }
        return count;
    }
}