// Last updated: 11/3/2026, 9:59:42 PM
1class Solution {
2    public long minOperations(int[] nums, int x, int k) {
3        long[] cost = medianSlidingWindow(nums, x);
4        int m = cost.length;
5        Long[][] dp = new Long[m][k + 1];
6        return solve(cost, 0, m, x, k, dp);
7    }
8
9    private long solve(long[] cost, int i, int m, int x, int k, Long[][] dp) {
10        if (k == 0) {
11            return 0;
12        }
13        if (i >= m) {
14            return (long)1e14;
15        }
16        if (dp[i][k] != null) {
17            return dp[i][k];
18        }
19        long notTake = solve(cost, i + 1, m, x, k, dp);
20        long take = cost[i] + solve(cost, i + x, m, x, k - 1, dp);
21        return dp[i][k] = Math.min(take, notTake);
22    }
23    public long[] medianSlidingWindow(int[] nums, int k) {
24        int n = nums.length, idx = 1;
25        int[] medians = new int[n - k + 1];
26        long[] cost = new long[n - k + 1];
27        TreeSet<int[]> maxHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
28        Integer.compare(b[0], a[0]) : b[1] - a[1]); // left
29        TreeSet<int[]> minHeap = new TreeSet<>((a, b) -> a[0] != b[0] ? 
30        Integer.compare(a[0], b[0]) : a[1] - b[1]); // right
31        long[] sum = new long[2]; // <maxHeapSum/leftSum, minHeapSum/rightSum>
32        for (int i = 0; i < k; i++) {
33            add(maxHeap, minHeap, nums, i, sum);
34        }
35        medians[0] = median(k, nums, maxHeap, minHeap);
36        cost[0] = sum[1] - sum[0] + (long) medians[0] * (maxHeap.size() - minHeap.size());
37        for (int i = k; i < n; i++) {
38            int[] old = new int[]{nums[i - k], i - k};
39            if (maxHeap.contains(old)) {
40                maxHeap.remove(old);
41                sum[0] -= old[0];
42            }
43            else {
44                minHeap.remove(old);
45                sum[1] -= old[0];
46            }
47            add(maxHeap, minHeap, nums, i, sum);
48            medians[idx] = median(k, nums, maxHeap, minHeap);
49            cost[idx] = sum[1] - sum[0] + (long) medians[idx++] * (maxHeap.size() - minHeap.size());
50        }
51        return cost;
52    }
53    private void add(TreeSet<int[]> maxHeap, TreeSet<int[]> minHeap, 
54    int[] nums, int i, long[] sum) {
55        maxHeap.add(new int[]{nums[i], i});
56        sum[0] += nums[i] - maxHeap.first()[0];
57        sum[1] += maxHeap.first()[0];
58        minHeap.add(maxHeap.pollFirst());
59        if (minHeap.size() > maxHeap.size()) {
60            sum[1] -= minHeap.first()[0];
61            sum[0] += minHeap.first()[0];
62            maxHeap.add(minHeap.pollFirst());
63        }
64    }
65    private int median(int k, int[] nums, TreeSet<int[]> maxHeap, 
66    TreeSet<int[]> minHeap) {
67        if (k % 2 == 0) {
68            return (maxHeap.first()[0] + minHeap.first()[0]) / 2;
69        }
70        else {
71            return maxHeap.first()[0];
72        }
73    }
74}