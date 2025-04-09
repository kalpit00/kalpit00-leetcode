// Last updated: 4/8/2025, 8:24:30 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        int[] map = new int[101];
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k) {
                count += map[num] == 0 ? 1 : 0;
                map[num]++;
            }
        }
        return count;
    }
}