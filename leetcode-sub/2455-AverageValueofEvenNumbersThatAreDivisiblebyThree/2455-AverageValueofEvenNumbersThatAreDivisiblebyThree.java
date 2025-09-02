// Last updated: 9/2/2025, 5:31:25 PM
class Solution {
    public int averageValue(int[] nums) {
        int count = 0, sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                count++;
                sum += num;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}