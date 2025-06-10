// Last updated: 6/10/2025, 2:52:38 AM
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1 + k2, max = 0;
        long sum = 0;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < n; i++) {
            bucket[diff[i]]++;
        }
        for (int i = max; i > 0; i--) {
            if (bucket[i] > 0) {
                int min = Math.min(bucket[i], k);
                bucket[i] -= min; // lower 'i' by min, inc 'i - 1' by min
                bucket[i - 1] += min;
                k -= min;
            }
        }
        for (int i = max; i > 0; i--) {
            sum += (long) bucket[i] * i * i;
        }
        return sum;
    }
}