// Last updated: 6/2/2025, 9:35:07 PM
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length, count = 0;
        boolean[] canOpen = new boolean[n], hasBox = new boolean[n], 
        visited = new boolean[n];
        for (int i = 0; i < n; ++i) {
            canOpen[i] = (status[i] == 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (canOpen[box]) {
                queue.offer(box);
                visited[box] = true;
                count += candies[box];
            }
        }
        while (!queue.isEmpty()) {
            int parent = queue.poll();
            for (int key : keys[parent]) {
                canOpen[key] = true;
                if (!visited[key] && hasBox[key]) {
                    queue.offer(key);
                    visited[key] = true;
                    count += candies[key];
                }
            }
            for (int box : containedBoxes[parent]) {
                hasBox[box] = true;
                if (!visited[box] && canOpen[box]) {
                    queue.offer(box);
                    visited[box] = true;
                    count += candies[box];
                }
            }
        }
        return count;
    }
}