// Last updated: 8/2/2025, 5:10:10 PM
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] map = new int[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        mergeSort(arr, map);
        List<Integer> res = new ArrayList<>();
        for (int num : map) {
            res.add(num);
        }
        return res;
    }

    private int[][] mergeSort(int[][] nums, int[] map) {
        if (nums.length <= 1) return nums;
        int n = nums.length, k = n / 2;
        int[][] left = new int[k][2], right = new int[n - k][2];
        for (int i = 0; i < k; i++) {
            left[i] = nums[i];
        }
        for (int i = k; i < n; i++) {
            right[i - k] = nums[i];
        }
        left = mergeSort(left, map);
        right = mergeSort(right, map);
        return merge(left, right, map);
    }

    private int[][] merge(int[][] left, int[][] right, int[] map) {
        int m = left.length, n = right.length, i = 0, j = 0, k = 0;
        int[][] res = new int[m + n][2];
        while (i < m && j < n) {
            if (left[i][0] <= right[j][0]) {
                map[left[i][1]] += j;
                res[k++] = left[i++];
            }  // just count all 'j' greater eles on the right 
            else {
                res[k++] = right[j++];
            }
        }
        while (i < m) {  // same here, add += 'j'
            map[left[i][1]] += j;
            res[k++] = left[i++];
        }
        while (j < n) {
            res[k++] = right[j++];
        }
        return res;
    }
}
