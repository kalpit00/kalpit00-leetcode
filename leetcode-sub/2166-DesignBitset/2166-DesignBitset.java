// Last updated: 7/27/2025, 1:42:11 AM
class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            int sum = 0, n = num;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}