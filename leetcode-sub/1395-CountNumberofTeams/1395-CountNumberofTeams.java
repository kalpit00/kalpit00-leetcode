// Last updated: 8/2/2025, 5:55:48 PM
class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = rating[i];
            arr[i][1] = i;
        }

        int[] left_smaller = new int[n];
        int[] left_greater = new int[n];
        int[] right_smaller = new int[n];
        int[] right_greater = new int[n];

        // Count left smaller
        mergeSort(arr.clone(), left_smaller, true);
        // Count left greater
        mergeSort(arr.clone(), left_greater, false);

        // For right counts, reverse the array
        int[][] reversed = new int[n][2];
        for (int i = 0; i < n; i++) {
            reversed[i][0] = rating[n - 1 - i];
            reversed[i][1] = n - 1 - i;
        }

        int[] right_smaller_rev = new int[n];
        int[] right_greater_rev = new int[n];

        mergeSort(reversed.clone(), right_smaller_rev, true);
        mergeSort(reversed.clone(), right_greater_rev, false);

        // Map right counts back to original order
        for (int i = 0; i < n; i++) {
            right_smaller[reversed[i][1]] = right_smaller_rev[n - 1 - i];
            right_greater[reversed[i][1]] = right_greater_rev[n - 1 - i];
        }

        // Calculate total teams
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += left_smaller[i] * right_greater[i] + left_greater[i] * right_smaller[i];
        }
        return result;
    }

    private int[][] mergeSort(int[][] nums, int[] counts, boolean countSmaller) {
        if (nums.length <= 1) return nums;

        int n = nums.length, mid = n / 2;
        int[][] left = new int[mid][2];
        int[][] right = new int[n - mid][2];
        System.arraycopy(nums, 0, left, 0, mid);
        System.arraycopy(nums, mid, right, 0, n - mid);

        left = mergeSort(left, counts, countSmaller);
        right = mergeSort(right, counts, countSmaller);

        return merge(left, right, counts, countSmaller);
    }

    private int[][] merge(int[][] left, int[][] right, int[] counts, boolean countSmaller) {
        int m = left.length, n = right.length, i = 0, j = 0, k = 0;
        int[][] merged = new int[m + n][2];

        while (i < m && j < n) {
            // If counting smaller: left[i][0] <= right[j][0] means left[i] is NOT greater than right[j]
            // If counting greater: left[i][0] >= right[j][0] means left[i] is NOT smaller than right[j]
            boolean condition = countSmaller ? (left[i][0] <= right[j][0]) : (left[i][0] >= right[j][0]);

            if (condition) {
                // When condition true, left[i] can "see" all right elements counted so far
                counts[left[i][1]] += j;
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < m) {
            counts[left[i][1]] += j;
            merged[k++] = left[i++];
        }
        while (j < n) {
            merged[k++] = right[j++];
        }
        return merged;
    }
}
