// Last updated: 8/2/2025, 5:37:35 PM
class Solution {
    long count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums);
        return (int) count;
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
            while (j < n && (long) left[i] > 2L * right[j]) {
                j++;
            }
            count += j;
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