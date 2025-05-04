// Last updated: 5/4/2025, 12:27:29 PM
import java.util.*;

class Solution {

    class SegmentData {
        long totalSum, prefixSum, suffixSum, maxSum;

        public SegmentData() {
            totalSum = 0;
            maxSum = Integer.MIN_VALUE;
            prefixSum = Integer.MIN_VALUE;
            suffixSum = Integer.MIN_VALUE;
        }

        public SegmentData(int value) {
            totalSum = value;
            maxSum = value;
            prefixSum = value;
            suffixSum = value;
        }
    }

    private List<SegmentData> segmentTree;

    private SegmentData merge(SegmentData left, SegmentData right) {
        SegmentData result = new SegmentData();
        result.totalSum = left.totalSum + right.totalSum;
        result.prefixSum = Math.max(left.prefixSum, left.totalSum + right.prefixSum);
        result.suffixSum = Math.max(right.suffixSum, right.totalSum + left.suffixSum);
        result.maxSum = Math.max(left.maxSum, right.maxSum);
        result.maxSum = Math.max(result.maxSum, result.prefixSum);
        result.maxSum = Math.max(result.maxSum, result.suffixSum);
        result.maxSum = Math.max(result.maxSum, left.suffixSum + right.prefixSum);
        return result;
    }

    private void buildTree(int left, int right, int index, int[] arr) {
        if (left == right) {
            segmentTree.set(index, new SegmentData(arr[left]));
            return;
        }
        int mid = (left + right) / 2;
        buildTree(left, mid, 2 * index + 1, arr);
        buildTree(mid + 1, right, 2 * index + 2, arr);
        segmentTree.set(index, merge(segmentTree.get(2 * index + 1), segmentTree.get(2 * index + 2)));
    }

    private void updateTree(int left, int right, int index, int position, int value) {
        if (position < left || position > right) return;
        if (left == right && position == left) {
            segmentTree.get(index).totalSum = segmentTree.get(index).prefixSum = segmentTree.get(index).suffixSum = segmentTree.get(index).maxSum = value;
            return;
        }
        int mid = (left + right) / 2;
        updateTree(left, mid, 2 * index + 1, position, value);
        updateTree(mid + 1, right, 2 * index + 2, position, value);
        segmentTree.set(index, merge(segmentTree.get(2 * index + 1), segmentTree.get(2 * index + 2)));
    }

    public long maxSubarraySum(int[] arr) {
        int n = arr.length;
        segmentTree = new ArrayList<>(4 * n);
        for (int i = 0; i < 4 * n; i++) {
            segmentTree.add(new SegmentData());
        }

        // Using TreeMap to store indices by value
        TreeMap<Integer, List<Integer>> valueToIndices = new TreeMap<>();
        buildTree(0, n - 1, 0, arr);
        long maxSubarraySum = segmentTree.get(0).maxSum;

        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        // If the largest value in the map is negative, return that value
        if (!valueToIndices.isEmpty() && valueToIndices.lastEntry().getKey() < 0) {
            return valueToIndices.lastEntry().getKey();
        }

        for (Map.Entry<Integer, List<Integer>> entry : valueToIndices.entrySet()) {
            int value = entry.getKey();
            List<Integer> indices = entry.getValue();
            if (indices.size() == n) continue;

            // Set elements at indices to 0 temporarily
            for (int idx : indices) updateTree(0, n - 1, 0, idx, 0);
            maxSubarraySum = Math.max(maxSubarraySum, segmentTree.get(0).maxSum);

            // Restore original values
            for (int idx : indices) updateTree(0, n - 1, 0, idx, value);
        }

        return maxSubarraySum;
    }
}