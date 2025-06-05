// Last updated: 6/5/2025, 5:21:34 PM
class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return nums[0];
        long prod = 1;
        boolean flag = false;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            if (num == 0) continue;
            flag = true;
            prod *= num;
            if (num < 0) {
                count++;
                min = Math.min(min, -num);
            }
        }
        return !flag || (max == 0 && count <= 1) ? 0 : 
        prod >= 0 ? prod : -prod / min;
    }
}