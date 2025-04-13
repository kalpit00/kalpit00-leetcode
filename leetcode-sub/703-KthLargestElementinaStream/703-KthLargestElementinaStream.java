// Last updated: 4/12/2025, 9:37:43 PM
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length, max = -1, uniqueMax = -1, res = -1; 
        int[] map = new int[51];
        for (int num : nums) {
            max = Math.max(max, num);
            map[num]++;
        }
        for (int num : nums) {
            uniqueMax = map[num] == 1 ? Math.max(uniqueMax, num) : uniqueMax;
        }
        if (k == 1) return uniqueMax;
        if (k == n) return max;
        if (map[nums[0]] == 1) {
            res = Math.max(res, nums[0]);
        }
        if (map[nums[n - 1]] == 1) {
            res = Math.max(res, nums[n - 1]);
        }
        return res;
    }
}