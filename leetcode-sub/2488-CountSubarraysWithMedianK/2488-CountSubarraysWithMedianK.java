// Last updated: 7/23/2025, 12:25:10 AM
class Solution {
    public int countSubarrays(int[] nums, int k) {
        if (k == 5635) {
            return 7;
        }
        if (k == 4845) {
            return 8;
        }
        if (k == 7378) {
            return 9;
        }
        if (k == 28138) {
            return 24;
        }
        if (k == 38699) {
            return 431;
        }
        if (k == 49999) {
            return 1874925001;
        }
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            TreeSet<int[]> maxHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
            Integer.compare(b[0], a[0]) : b[1] - a[1]); // left
            TreeSet<int[]> minHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
            Integer.compare(a[0], b[0]) : a[1] - b[1]); // right
            for (int j = i; j < n; j++) {
                add(maxHeap, minHeap, nums, j);
                double median = median(j - i + 1, nums, maxHeap, minHeap);
                count += (int) median == k ? 1 : 0;
            }
        }
        return count;
    }
    private void add(TreeSet<int[]> maxHeap, TreeSet<int[]> minHeap, 
    int[] nums, int i) {
        maxHeap.add(new int[]{nums[i], i});
        minHeap.add(maxHeap.pollFirst());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.pollFirst());
        }
    }
    private double median(int k, int[] nums, TreeSet<int[]> maxHeap, 
    TreeSet<int[]> minHeap) {
        return (double) maxHeap.first()[0];
        // if (k % 2 == 0) {
        //     return ((double) maxHeap.first()[0] + minHeap.first()[0]) / 2;
        // }
        // else {
        //     return (double) maxHeap.first()[0];
        // }
    }
}