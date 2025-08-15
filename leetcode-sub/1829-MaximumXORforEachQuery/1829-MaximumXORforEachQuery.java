// Last updated: 8/15/2025, 5:20:39 AM
class Solution {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums = new int[n][2];
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i][0] = nums1[i];
            nums[i][1] = i;
        }
        // Arrays.sort(nums, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int idx = nums[i][1];
            if (i > 0 && nums[i][0] == nums[i - 1][0]) {
                res[idx] = res[nums[i - 1][1]];
            }
            else {
                res[idx] = sum;
            }
            sum += nums2[idx];
            pq.offer(nums2[idx]);
            if (pq.size() > k) {
                sum -= pq.poll();
            }
        }
        return res;
    }
}