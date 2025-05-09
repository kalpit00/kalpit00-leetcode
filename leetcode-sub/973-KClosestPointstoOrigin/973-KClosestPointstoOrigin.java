// Last updated: 5/9/2025, 3:18:55 PM
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int[] point : points) {
            pq.offer(new int[]{point[0], point[1], helper(point)});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int i = 0;
        int[][] res = new int[k][2];
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            res[i][0] = point[0];
            res[i++][1] = point[1];
        }
        return res;
    }
    private int helper(int[] point) {
        int x = point[0], y = point[1];
        return (x * x) + (y * y);
    }
}