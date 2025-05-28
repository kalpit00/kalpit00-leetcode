// Last updated: 5/28/2025, 5:33:06 AM
class Solution {
    public int containVirus(int[][] isInfected) {

        final int m = isInfected.length;
        final int n = isInfected[0].length;
        int totalWalls = 0;

        while (true) {
            List<Region> regions = new ArrayList<>();
            boolean[][] visited = new boolean[m][n];

            // Identify all regions
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (isInfected[i][j] == 1 && !visited[i][j]) {
                        Region region = new Region();
                        dfs(isInfected, i, j, region, visited, m, n);
                        if (!region.nonInfected.isEmpty()) {
                            regions.add(region);
                        }
                    }
                }
            }

            if (regions.isEmpty()) {
                break; // No more regions to process
            }

            // Find the region with the most threats
            int maxThreatIndex = 0;
            for (int i = 1; i < regions.size(); ++i) {
                if (regions.get(i).nonInfected.size() > regions.get(maxThreatIndex).nonInfected.size()) {
                    maxThreatIndex = i;
                }
            }

            // Build walls around the most threatening region
            totalWalls += regions.get(maxThreatIndex).wallsRequired;
            for (int pos : regions.get(maxThreatIndex).infected) {
                int x = pos / n;
                int y = pos % n;
                isInfected[x][y] = 2; // Mark as contained
            }

            // Spread the virus for other regions
            for (int i = 0; i < regions.size(); ++i) {
                if (i == maxThreatIndex) continue;
                for (int pos : regions.get(i).nonInfected) {
                    int x = pos / n;
                    int y = pos % n;
                    isInfected[x][y] = 1;
                }
            }
        }

        return totalWalls;
    }

    private void dfs(int[][] grid, int i, int j, Region region, boolean[][] visited, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 0) {
            region.nonInfected.add(i * n + j);
            region.wallsRequired++;
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }

        visited[i][j] = true;
        region.infected.add(i * n + j);

        dfs(grid, i + 1, j, region, visited, m, n);
        dfs(grid, i - 1, j, region, visited, m, n);
        dfs(grid, i, j + 1, region, visited, m, n);
        dfs(grid, i, j - 1, region, visited, m, n);        
    }
    class Region {
        Set<Integer> infected = new HashSet<>();
        Set<Integer> nonInfected = new HashSet<>();
        int wallsRequired = 0;
    }    
}