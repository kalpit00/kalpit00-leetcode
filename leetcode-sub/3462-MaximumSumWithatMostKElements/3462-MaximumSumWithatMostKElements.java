// Last updated: 5/2/2025, 9:31:31 PM
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = limits.length, m = grid[0].length;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.offer(grid[i][j]);
                if (pq.size() > limits[i]) {
                    pq.poll();
                }
            }
            while (!pq.isEmpty()) {
                list.add(pq.poll());
            }
        }
        for (int num : list) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }
        return sum;
    }
}