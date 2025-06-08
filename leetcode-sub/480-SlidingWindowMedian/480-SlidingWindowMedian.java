// Last updated: 6/8/2025, 12:52:27 AM
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? 
        Integer.compare(nums[a], nums[b]) : a - b; // use .compare for overflow
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed()); // maxHeap
        TreeSet<Integer> right = new TreeSet<>(comparator); // minHeap!
        for (int i = 0; i < k; i++) {
            left.add(i); // add the first "k" elements and balance
        }
        balance(left, right);
        res[0] = median(k, nums, left, right); // get median for first k
        int idx = 1; // now, slide through remaining n - k elements
        for (int i = k; i < n; i++) {
            if (!left.remove(i - k)) { // trick to know which set the old (i-k)
                right.remove(i - k); // element belongs!
            }
            right.add(i); // similar to median of data stream logic!
            left.add(right.pollFirst());
            balance(left, right);
            res[idx++] = median(k, nums, left, right);
        }
        return res;
    }
    private void balance(TreeSet<Integer> left, TreeSet<Integer> right) {
        while (left.size() > right.size()) {
            right.add(left.pollFirst());
        }
    }
    private double median(int k, int[] nums, TreeSet<Integer> left, 
    TreeSet<Integer> right) {
        if (k % 2 == 0) {
            return ((double) nums[left.first()] + nums[right.first()]) / 2;
        }
        else {
            return (double) nums[right.first()];
        }
    }
}