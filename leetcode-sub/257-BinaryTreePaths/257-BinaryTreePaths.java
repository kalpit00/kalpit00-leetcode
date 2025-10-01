// Last updated: 10/1/2025, 7:40:43 PM
class Solution {
    public int minOperations(int[] nums) {
        int sum = 0, max = 0;
        for (int num : nums) {
            if (num == 0) continue;
            sum += Integer.bitCount(num);
            max = Math.max(max, Integer.numberOfTrailingZeros(Integer.highestOneBit(num)));
        }
        return sum + max;
    }
}