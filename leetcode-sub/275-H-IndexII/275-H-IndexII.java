// Last updated: 5/22/2025, 4:24:51 AM
class Solution {
    public int maximumPossibleSize(int[] nums) {
        int count = 0, prev = -1;
        for (int curr : nums) {
            if (curr >= prev) {
                prev = curr;
                count++;
            }
        }
        return count;
    }
}