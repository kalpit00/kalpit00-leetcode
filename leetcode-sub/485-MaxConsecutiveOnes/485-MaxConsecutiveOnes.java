// Last updated: 11/15/2025, 11:48:45 PM
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, max = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int m = 1; // m = streak length
            flag = nums[i] == 1 ? true : flag;
            while (i < n - 1 && nums[i] == 1 && nums[i] == nums[i + 1]) {
                i++;
                m++;
            }
            max = Math.max(max, m);
        }
        return flag ? max : 0;
    }
}