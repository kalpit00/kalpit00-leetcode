// Last updated: 6/8/2025, 1:07:12 PM
class Solution {
    public long minOperations(int[] nums, int x, int k) {
        long[] cost = medianSlidingWindow(nums, x);
        int m = cost.length;
        Long[][] dp = new Long[m + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0L;
        }        
        for (int j = 1; j <= k; j++) {
            dp[m][j] = (long)1e14;
        }        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                long notTake = dp[i + 1][j];                
                long take = cost[i] + (i + x <= m ? dp[i + x][j - 1] : 
                    (j == 1 ? 0 : (long) 1e14));
                dp[i][j] = Math.min(take, notTake);
            }
        }
        return dp[0][k];
    }

    public long[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length, idx = 1;
        int[] medians = new int[n - k + 1];
        long[] cost = new long[n - k + 1];
        TreeSet<int[]> maxHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        b[0] - a[0] : b[1] - a[1]); // left
        TreeSet<int[]> minHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
        a[0] - b[0] : a[1] - b[1]); // right
        long[] sum = new long[2]; // <maxHeapSum/leftSum, minHeapSum/rightSum>
        for (int i = 0; i < k; i++) {
            add(maxHeap, minHeap, nums, i, sum);
        }
        medians[0] = median(k, nums, maxHeap, minHeap);
        cost[0] = sum[1] - sum[0] + (long) medians[0] * (maxHeap.size() - minHeap.size());
        for (int i = k; i < n; i++) {
            int[] old = new int[]{nums[i - k], i - k};
            if (maxHeap.contains(old)) {
                maxHeap.remove(old);
                sum[0] -= old[0];
            }
            else {
                minHeap.remove(old);
                sum[1] -= old[0];
            }
            add(maxHeap, minHeap, nums, i, sum);
            medians[idx] = median(k, nums, maxHeap, minHeap);
            cost[idx] = sum[1] - sum[0] + (long) medians[idx++] * (maxHeap.size() - minHeap.size());
        }
        return cost;
    }
    private void add(TreeSet<int[]> maxHeap, TreeSet<int[]> minHeap, 
    int[] nums, int i, long[] sum) {
        sum[0] += nums[i]; // add nums[i] to maxHp
        maxHeap.add(new int[]{nums[i], i}); // move top from maxHp to minHp
        sum[1] += maxHeap.first()[0]; // so add to minHp
        sum[0] -= maxHeap.first()[0]; // and subtract from maxHp
        minHeap.add(maxHeap.pollFirst());
        if (minHeap.size() > maxHeap.size()) {
            sum[1] -= minHeap.first()[0]; // so subtract from minHp
            sum[0] += minHeap.first()[0]; // and add to maxHp
            maxHeap.add(minHeap.pollFirst()); // since move from minHP to maxHP
        }
    }
    private int median(int k, int[] nums, TreeSet<int[]> maxHeap, 
    TreeSet<int[]> minHeap) {
        if (k % 2 == 0) {
            return (maxHeap.first()[0] + minHeap.first()[0]) / 2;
        }
        else {
            return maxHeap.first()[0];
        }
    }
}