// Last updated: 5/28/2025, 2:47:10 AM
class Solution {
    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<Region> pq = new PriorityQueue<>((a, b) -> b.unInfected.size() - a.unInfected.size());
        int count = 0, days = 1; // start with day 1
        contain(grid, days, m, n, pq); // get the most deadly region first
        while (!pq.isEmpty()) {
            Region curr = pq.poll();
            count += curr.count;
            for (int node : curr.infected) {
                int i = node / n, j = node % n;
                grid[i][j] = -1;
            } // visit all the nodes in this region! set them to -1
            days++; // move to next day.
            while (!pq.isEmpty()) {
                Region next = pq.poll(); // now get all uninfected neighbors
                for (int neighbor : next.unInfected) {
                    int r = neighbor / n, c = neighbor % n;
                    grid[r][c] = days; // set cells to 'days'
                }
            }
            contain(grid, days, m, n, pq); // contain next region
        }
        return count;
    }
    private void contain(int[][] grid, int days, int m, int n, 
    PriorityQueue<Region> pq) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == days) {
                    Region region = new Region();
                    dfs(grid, days, i, j, m, n, region);
                    if (!region.unInfected.isEmpty()) {
                        pq.offer(region);
                    }
                }
            }
        }
    }
    private void dfs(int[][] grid, int days, int i, int j, int m, int n,
    Region region) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1 || 
        grid[i][j] > days) {
            return; // use -1 for visited
        }
        if (grid[i][j] == 0) {
            region.unInfected.add(i * n + j); // idx = i * n + j trick!
            region.count++; // increase wall count for this region
            return;
        }
        grid[i][j]++; // increment each cell value each day!
        region.infected.add(i * n + j);
        dfs(grid, days, i + 1, j, m, n, region);
        dfs(grid, days, i - 1, j, m, n, region);
        dfs(grid, days, i, j + 1, m, n, region);
        dfs(grid, days, i, j - 1, m, n, region);
    }
    class Region {
        Set<Integer> infected = new HashSet<>(); // infected cells in region
        Set<Integer> unInfected = new HashSet<>(); // uninfected neighbors
        int count = 0; // count of walls needed to contain region
    }
}