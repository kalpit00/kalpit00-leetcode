// Last updated: 4/11/2025, 8:41:53 PM
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
            int steps = bfs(forest, nums.get(i - 1), nums.get(i), m, n);
            if (steps == -1) {
                return -1;
            }
            sum += steps;
        }
        return sum;
    }
    private int bfs(List<List<Integer>> forest, int[] src, int[] dest, 
    int m, int n) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(src);
        visited[src[0]][src[1]] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];
                if (x == dest[0] && y == dest[1]) {
                    return steps;
                }
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] &&
                    forest.get(r).get(c) != 0) {
                        visited[r][c] = true;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}