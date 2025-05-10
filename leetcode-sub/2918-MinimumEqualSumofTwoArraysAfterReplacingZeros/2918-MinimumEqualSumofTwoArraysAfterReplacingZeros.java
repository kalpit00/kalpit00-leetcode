// Last updated: 5/10/2025, 12:52:36 AM
class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0, count1 = 0, count2 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                sum1++; // add 1 for each 0
                count1++; // count 0s
            }
        }
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                sum2++;
                count2++;
            }
        }
        if ((count1 == 0 && sum2 > sum1) || (count2 == 0 && sum1 > sum2)) {
            return -1;
        }
        return Math.max(sum1, sum2);
    }
}