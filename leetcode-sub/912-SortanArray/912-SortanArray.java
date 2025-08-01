// Last updated: 8/1/2025, 1:06:44 AM
class Solution {    
    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }
    
    private int[] quickSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return nums;
        }
        int pivot = nums[new Random().nextInt(n)];
        int l = 0, e = 0, r = 0,  a = 0, b = 0, c = 0;        
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                a++;
            } else if (nums[i] == pivot) {
                b++;
            } else {
                c++;
            }
        }
        int[] left = new int[a], equal = new int[b], right = new int[c];
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                left[l++] = nums[i];
            } else if (nums[i] == pivot) {
                equal[e++] = nums[i];
            } else {
                right[r++] = nums[i];
            }
        }
        left = quickSort(left);
        right = quickSort(right);        
        return merge(left, equal, right);
    }
    
    private int[] merge(int[] left, int[] equal, int[] right) {
        int m = left.length, e = equal.length, n = right.length, k = 0;
        int[] res = new int[m + e + n];
        for (int i = 0; i < m; i++) {
            res[k++] = left[i];
        }        
        for (int i = 0; i < e; i++) {
            res[k++] = equal[i];
        }        
        for (int i = 0; i < n; i++) {
            res[k++] = right[i];
        }
        return res;
    }
}