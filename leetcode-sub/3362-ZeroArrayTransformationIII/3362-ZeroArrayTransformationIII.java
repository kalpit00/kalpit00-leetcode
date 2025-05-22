// Last updated: 5/21/2025, 11:09:57 PM
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int m = queries.length, n = nums.length, sum = 0;
        int[] count = new int[n + 1];
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0, j = 0; i < n; i++) {
            sum += count[i];
            while (j < m && queries[j][0] == i) {
                pq.offer(queries[j][1]);
                j++;
            }
            while (sum < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sum += 1;
                count[pq.poll() + 1] -= 1;
            }
            if (sum < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }
}