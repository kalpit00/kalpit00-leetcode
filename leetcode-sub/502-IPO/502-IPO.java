// Last updated: 4/10/2025, 3:34:03 AM
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = profits[i];
            projects[i][1] = capital[i];
        }
        Arrays.sort(projects, (a, b) -> a[1] - b[1]);
        int j = 0;
        for (int i = 0; i < k; i++) {
            while (j < n && projects[j][1] <= w) {
                maxHeap.offer(projects[j++]);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll()[0];
        }
        return w;
    }
}