// Last updated: 8/2/2025, 5:13:09 PM
import java.util.*;

class Solution {
    int[] nums;
    int[] answers;

    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        answers = new int[n];

        // We use an array of indices to avoid moving the actual nums array around
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        mergeSort(indices, 0, n - 1);

        // Convert answers array to List<Integer>
        List<Integer> result = new ArrayList<>();
        for (int val : answers) result.add(val);
        return result;
    }

    private int[] mergeSort(int[] indices, int left, int right) {
        if (left == right) return new int[]{indices[left]};

        int mid = (left + right) / 2;
        int[] leftSorted = mergeSort(indices, left, mid);
        int[] rightSorted = mergeSort(indices, mid + 1, right);

        return merge(leftSorted, rightSorted);
    }

    private int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (nums[left[i]] <= nums[right[j]]) {
                // No count is added, because nums[left[i]] <= nums[right[j]]
                merged[k++] = right[j++];
            } else {
                // nums[left[i]] > nums[right[j]]
                // All remaining right[j:] are smaller
                answers[left[i]] += right.length - j;
                merged[k++] = left[i++];
            }
        }

        // Dump remaining elements
        while (i < left.length) merged[k++] = left[i++];
        while (j < right.length) merged[k++] = right[j++];

        return merged;
    }
}