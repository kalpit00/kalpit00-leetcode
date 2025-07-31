// Last updated: 7/31/2025, 5:39:14 PM
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }
        int n = nums.length, k = n / 2;
        int[] left = new int[k], right = new int[n - k];
        for (int i = 0; i < k; i++) {
            left[i] = nums[i];
        }
        for (int i = k; i < n; i++) {
            right[i - k] = nums[i];
        }
        left = sortArray(left);
        right = sortArray(right);
        return merge(left, right);
    }
    
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            }
            else {
                res[k++] = nums2[j++];
            }
        }
        while (i < m) {
            res[k++] = nums1[i++];
        }
        while (j < n) {
            res[k++] = nums2[j++];
        }
        return res;
    }
}
