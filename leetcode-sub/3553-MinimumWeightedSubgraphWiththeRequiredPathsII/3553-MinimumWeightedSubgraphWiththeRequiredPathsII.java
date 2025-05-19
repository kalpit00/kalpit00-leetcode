// Last updated: 5/19/2025, 1:10:55 AM
class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, max = 0; // max the prefixSum Average!
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i]; // there are (i + 1) elements in sum[0..i]
            max = Math.max(max, (sum + i) / (i + 1));
        } // avg is simply sum / i + 1, get the ceiling!
        return (int) max;
    }
}