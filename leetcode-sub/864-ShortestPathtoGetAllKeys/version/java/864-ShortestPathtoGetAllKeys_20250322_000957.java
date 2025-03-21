// Last updated: 3/22/2025, 12:09:57 AM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0; 
        for (int i = low; i <= high; i++) {
            String value = String.valueOf(i);
            int n = value.length();
            if (n % 2 == 0) {
                String firstHalf = value.substring(0, n / 2);
                String secondHalf = value.substring(n / 2);
                if (digitSum(firstHalf) == digitSum(secondHalf)) {
                    count++;
                }
            }
        }
        return count;
    }
    public static int digitSum(String digit) {
        int n = Integer.parseInt(digit), sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
