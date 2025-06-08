// Last updated: 6/8/2025, 12:53:24 AM
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 1;
        double[] res = new double[n - k + 1];
        TreeSet<int[]> left = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        Integer.compare(b[0], a[0]) : b[1] - a[1]); // maxHeap
        TreeSet<int[]> right = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        Integer.compare(a[0], b[0]) : a[1] - b[1]); // minHeap
        for (int i = 0; i < k; i++) {
            left.add(new int[]{nums[i], i}); 
        } // add the first "k" elements and balance
        balance(left, right);
        res[0] = median(k, nums, left, right); // get median for first k
        for (int i = k; i < n; i++) {
            int[] key = new int[]{nums[i - k], i - k};
            if (!left.remove(key)) { 
                right.remove(key);
            }
            right.add(new int[]{nums[i], i});
            left.add(right.pollFirst());
            balance(left, right);
            res[idx++] = median(k, nums, left, right);
        }
        return res;
    }
    private void balance(TreeSet<int[]> left, TreeSet<int[]> right) {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }
    private double median(int k, int[] nums, TreeSet<int[]> left, 
    TreeSet<int[]> right) {
        if (k % 2 == 0) {
            return ((double) left.first()[0] + right.first()[0]) / 2;
        }
        else {
            return (double) right.first()[0];
        }
    }
}