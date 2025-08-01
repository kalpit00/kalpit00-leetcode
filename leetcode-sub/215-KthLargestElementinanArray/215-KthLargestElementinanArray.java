// Last updated: 8/1/2025, 2:04:14 AM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        nums = sortArray(nums);
        return nums[nums.length - k];
    }
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }
    
    private int[] quickSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int pivot = nums[new Random().nextInt(n)];
        int l = 0, r = 0, m = 0, k = 0, j = 0;
        for (int i = 0; i < n; i++) {
            k += nums[i] == pivot ? 1 : 0;
            m += nums[i] < pivot ? 1 : 0;
        }
        int[] left = new int[m], mid = new int[k], right = new int[n - m - k];
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                left[l++] = nums[i];
            } else if (nums[i] == pivot) {
                mid[j++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }
        left = quickSort(left);
        right = quickSort(right);        
        return merge(left, mid, right);
    }
    
    private int[] merge(int[] left, int[] mid, int[] right) {
        int m = left.length, j = mid.length, n = right.length, k = 0;
        int[] res = new int[m + j + n];
        for (int i = 0; i < m; i++) {
            res[k++] = left[i];
        }        
        for (int i = 0; i < j; i++) {
            res[k++] = mid[i];
        }        
        for (int i = 0; i < n; i++) {
            res[k++] = right[i];
        }
        return res;
    }
}