// Last updated: 4/12/2025, 1:14:39 AM
class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size(), sum = 0;
        List<int[]> nums = new ArrayList<>();
        nums.add(new int[]{0, 0, 0});
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) <= 1) {
                    continue; // skip empty or wall cells
                }
                nums.add(new int[]{i, j, forest.get(i).get(j)});
            }
        }
        Collections.sort(nums, (a, b) -> a[2] - b[2]);
        for (int i = 1; i < nums.size(); i++) {
            int[] src = nums.get(i - 1), dest = nums.get(i);
            int steps = bidirectional_bfs(forest, src, dest, m, n);
            if (steps == -1) {
                return -1;
            }
            sum += steps;
        }
        return sum;
    }
    private int bidirectional_bfs(List<List<Integer>> forest, int[] src, int[] dest, int m, int n) {
        if (src[0] == dest[0] && src[1] == dest[1]) return 0;
        Queue<int[]> queue1 = new LinkedList<>(), queue2 = new LinkedList<>();
        boolean[][] visited1 = new boolean[m][n], visited2 = new boolean[m][n];
        queue1.offer(src);
        queue2.offer(dest);
        visited1[src[0]][src[1]] = true;
        visited2[dest[0]][dest[1]] = true;
        int steps = 0;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.size() > queue2.size()) {
                Queue<int[]> tempQueue = queue1;
                queue1 = queue2;
                queue2 = tempQueue;
                boolean[][] tempSet = visited1; 
                visited1 = visited2; 
                visited2 = tempSet;
            }
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue1.poll();
                int x = node[0], y = node[1];
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || 
                    forest.get(r).get(c) == 0 || visited1[r][c]) {
                        continue;
                    }
                    if (visited2[r][c]) {
                        return steps + 1;
                    }
                    visited1[r][c] = true;
                    queue1.offer(new int[]{r, c});
                }
            }
            steps++;
        }
        return -1;
    }
}