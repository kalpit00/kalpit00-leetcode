// Last updated: 6/18/2025, 3:08:04 PM
class Solution {
    public int minimumXORSum(int[] nums1, int[] nums2) {
        int n = nums1.length;        
        int[][] cost = buildCostMatrix(nums1, nums2, n);
        return hungarianAssignment(cost);
    }
    
    private int[][] buildCostMatrix(int[] nums1, int[] nums2, int n) {
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Cost of assigning nums1[i] to nums2[j]
                cost[i][j] = nums1[i] ^ nums2[j];
            }
        }
        return cost;
    }
    
    /**
     * Standardized Hungarian Algorithm Template for Assignment Problem
     * Finds minimum cost perfect matching in complete bipartite graph
     * Time Complexity: O(n^3)
     * Space Complexity: O(n^2)
     */
    private int hungarianAssignment(int[][] cost) {
        int n = cost.length;
        
        // Potentials for rows and columns
        int[] u = new int[n + 1]; // Row potentials (workers)
        int[] v = new int[n + 1]; // Column potentials (jobs)
        
        // Assignment arrays
        int[] p = new int[n + 1]; // p[j] = i means job j is assigned to worker i
        int[] way = new int[n + 1]; // For reconstructing augmenting path
        
        // Process each worker
        for (int i = 1; i <= n; i++) {
            p[0] = i; // Start with unassigned job 0 -> worker i
            int j0 = 0;
            
            // Dijkstra-like search for augmenting path
            int[] minv = new int[n + 1]; // Minimum reduced cost to reach each job
            boolean[] used = new boolean[n + 1]; // Visited jobs in current iteration
            Arrays.fill(minv, Integer.MAX_VALUE);
            
            do {
                used[j0] = true;
                int i0 = p[j0]; // Current worker assigned to job j0
                int delta = Integer.MAX_VALUE;
                int j1 = 0;
                
                // Update minimum costs to all unvisited jobs
                for (int j = 1; j <= n; j++) {
                    if (!used[j]) {
                        int cur = cost[i0 - 1][j - 1] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0; // Remember path
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }
                
                // Update potentials
                for (int j = 0; j <= n; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                
                j0 = j1;
            } while (p[j0] != 0); // Continue until we reach an unassigned job
            
            // Reconstruct and apply augmenting path
            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }
        
        // Return minimum cost (stored in -v[0])
        return -v[0];
    }
}