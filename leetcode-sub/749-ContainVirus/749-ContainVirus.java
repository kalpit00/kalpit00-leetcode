// Last updated: 5/29/2025, 3:34:03 AM
class Solution {
    public int containVirus(int[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        List<Region> list = new ArrayList<>();
        list.add(new Region()); // add dummy region or use while true loop
        while (!list.isEmpty()) {
            List<Region> regions = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        Region region = new Region();
                        dfs(grid, i, j, m, n, region, visited);
                        if (!region.unInfected.isEmpty()) {
                            regions.add(region);
                        }
                    }
                }
            }
            if (regions.isEmpty()) {
                break; // prune if all regions contained!
            }
            int max = 0;
            for (int i = 0; i < regions.size(); i++) {
                if (regions.get(i).unInfected.size() > 
                regions.get(max).unInfected.size()) {
                    max = i;
                }
            }
            count += regions.get(max).count;
            for (int idx : regions.get(max).infected) {
                int i = idx / n, j = idx % n;
                grid[i][j] = -1;
            } 
            for (int i = 0; i < regions.size(); i++) {
                if (i == max) continue;
                for (int idx : regions.get(i).unInfected) {
                    int r = idx / n, c = idx % n;
                    grid[r][c] = 1; 
                }
            }
            list = regions;
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j, int m, int n,
    Region region, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || 
        grid[i][j] == -1) {
            return;
        }
        if (grid[i][j] == 0) {
            region.unInfected.add(i * n + j); // idx = i * n + j trick!
            region.count++; // increase wall count for this region
            return;
        }
        visited[i][j] = true;
        region.infected.add(i * n + j);
        dfs(grid, i + 1, j, m, n, region, visited);
        dfs(grid, i - 1, j, m, n, region, visited);
        dfs(grid, i, j + 1, m, n, region, visited);
        dfs(grid, i, j - 1, m, n, region, visited);
    }
    class Region {
        Set<Integer> infected = new HashSet<>(); // infected cells in region
        Set<Integer> unInfected = new HashSet<>(); // uninfected neighbors
        int count = 0; // count of walls needed to contain region
    }
}