// Last updated: 6/8/2025, 1:27:07 AM
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 1;
        double[] res = new double[n - k + 1];
        TreeSet<int[]> maxHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        Integer.compare(b[0], a[0]) : b[1] - a[1]); // left
        TreeSet<int[]> minHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        Integer.compare(a[0], b[0]) : a[1] - b[1]); // right
        for (int i = 0; i < k; i++) {
            add(maxHeap, minHeap, nums, i);
        }
        res[0] = median(k, nums, maxHeap, minHeap);
        for (int i = k; i < n; i++) {
            int[] old = new int[]{nums[i - k], i - k};
            if (!maxHeap.remove(old)) { // min/maxHeaps swappable here!
                minHeap.remove(old);
            }
            add(maxHeap, minHeap, nums, i);
            res[idx++] = median(k, nums, maxHeap, minHeap);
        }
        return res;
    }
    private void add(TreeSet<int[]> maxHeap, TreeSet<int[]> minHeap, 
    int[] nums, int i) {
        maxHeap.add(new int[]{nums[i], i});
        minHeap.add(maxHeap.pollFirst());
        while (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.pollFirst());
        }
    }
    private double median(int k, int[] nums, TreeSet<int[]> maxHeap, 
    TreeSet<int[]> minHeap) {
        if (k % 2 == 0) {
            return ((double) maxHeap.first()[0] + minHeap.first()[0]) / 2;
        }
        else {
            return (double) maxHeap.first()[0];
        }
    }
}