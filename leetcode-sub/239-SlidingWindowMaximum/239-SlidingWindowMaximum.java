// Last updated: 6/9/2025, 1:08:25 AM
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 1;
        int[] res = new int[n - k + 1];
        TreeSet<int[]> maxHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        Integer.compare(b[0], a[0]) : b[1] - a[1]); // left
        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[]{nums[i], i});
        }
        res[0] = maxHeap.first()[0];
        for (int i = k; i < n; i++) {
            int[] old = new int[]{nums[i - k], i - k};
            maxHeap.remove(old);
            maxHeap.add(new int[]{nums[i], i});
            res[idx++] = maxHeap.first()[0];
        }
        return res;
    }
}