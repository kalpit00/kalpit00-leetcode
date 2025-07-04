// Last updated: 7/4/2025, 12:08:46 AM
class Solution {
    public long kSum(int[] nums, int k) {
        long sum = 0, total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            total += nums[i] > 0 ? nums[i] : 0;
            nums[i] = nums[i] < 0 ? -nums[i] : nums[i];
        }
        Arrays.sort(nums);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{nums[0], 0});
        while (k > 1) {
            long[] item = pq.poll();
            int i = (int) item[1]++;
            long val = item[0];
            sum = val;
            if (i < n - 1) {
                item[0] += nums[i + 1];
                pq.offer(new long[]{val - nums[i] + nums[i + 1], i + 1});
                pq.offer(item);
            }
            k--;
        }
        return total - sum;
    }
}