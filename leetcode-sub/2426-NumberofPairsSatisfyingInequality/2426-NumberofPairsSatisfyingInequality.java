// Last updated: 8/2/2025, 5:46:23 PM
class Solution {
    long count = 0;
    int diff;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        this.diff = diff;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }
        mergeSort(nums);
        return count;
    }
    private int[] mergeSort(int[] nums) {
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
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    
    private int[] merge(int[] left, int[] right) {
        int m = left.length, n = right.length, i = 0, j = 0, k = 0;
        int[] res = new int[m + n];
        for (i = 0; i < m; i++) {
            while (j < n && left[i] > right[j] + diff) {
                j++;
            }
            count += (n - j);
        }
        i = 0;
        j = 0;
        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                res[k++] = left[i++];
            }
            else {
                res[k++] = right[j++];
            }
        }
        while (i < m) {
            res[k++] = left[i++];
        }
        while (j < n) {
            res[k++] = right[j++];
        }
        return res;
    }
}