// Last updated: 3/22/2025, 11:07:38 PM
class Solution {
    public int countBeautifulPairs(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int last = nums[i] % 10; // just get last digit of nums[i] rn
            for (int j = 0; j < i; j++) {
                int temp = nums[j]; // store so we don't modify nums
                int first = nums[j]; // use to get first digit of nums[j]
                while (temp > 0) {
                    first = temp % 10;
                    temp /= 10;
                }
                count += gcd(first, last) == 1 ? 1 : 0;
            }
        }
        return count;
    }
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}