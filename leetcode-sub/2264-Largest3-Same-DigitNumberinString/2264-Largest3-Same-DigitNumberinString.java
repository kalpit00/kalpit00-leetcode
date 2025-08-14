// Last updated: 8/13/2025, 8:06:21 PM
class Solution {
    public String largestGoodInteger(String num) {
        char max = Character.MIN_VALUE;
        char[] nums = num.toCharArray();
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
        }
        return max == Character.MIN_VALUE ? "" : 
        new String(new char[]{max, max, max});
    }
}