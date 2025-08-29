// Last updated: 8/29/2025, 6:12:45 PM
class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) {
            return false;
        }
        int m = n / k;
        int[] map = new int[1000001];
        for (int num : nums) {
            map[num]++;
        }
        for (int num : nums) {
            if (map[num] > m) {
                return false;
            }
        }
        return true;
    }
}