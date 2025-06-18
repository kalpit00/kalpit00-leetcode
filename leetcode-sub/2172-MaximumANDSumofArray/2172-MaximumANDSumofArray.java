// Last updated: 6/18/2025, 4:15:13 PM
class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        int n = nums.length;
        int m = 2 * numSlots;
        int[][] cost = buildCostMatrix(nums, numSlots, n, m);
        return -hungarian(cost, true);
    }
    
    private int[][] buildCostMatrix(int[] nums, int numSlots, int n, int m) {
        int size = Math.max(n, m);
        int[][] cost = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i < n && j < m) {  // Position j belongs to slot (j/2 + 1)
                    int slotNumber = (j / 2) + 1;
                    cost[i][j] = -(nums[i] & slotNumber); 
                } 
                else { // Negative for maximization
                    cost[i][j] = 0;
                } // Dummy assignment with cost 0
            }
        }
        return cost;
    }
    
    private int hungarian(int[][] cost, boolean minimize) {
        int m = cost.length, n = cost[0].length;
        if (m > n) {
            int[][] transposed = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    transposed[j][i] = cost[i][j];
                }
            }
            cost = transposed;
            int temp = m;
            m = n;
            n = temp;
        }
        if (!minimize) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cost[i][j] *= -1;
                }
            }   
        }
        int[] u = new int[m + 1], v = new int[n + 1];
        int[] p = new int[n + 1], way = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            p[0] = i;
            int[] minv = new int[n + 1];
            boolean[] used = new boolean[n + 1];
            Arrays.fill(minv, Integer.MAX_VALUE);
            int j0 = 0;
            do {
                used[j0] = true;
                int i0 = p[j0], delta = Integer.MAX_VALUE, j1 = -1;
                for (int j = 1; j <= n; j++) {
                    if (!used[j]) {
                        int cur = cost[i0 - 1][j - 1] - u[i0] - v[j];
                        if (cur < minv[j]) {
                            minv[j] = cur;
                            way[j] = j0;
                        }
                        if (minv[j] < delta) {
                            delta = minv[j];
                            j1 = j;
                        }
                    }
                }
                for (int j = 0; j <= n; j++) {
                    if (used[j]) {
                        u[p[j]] += delta;
                        v[j] -= delta;
                    } else {
                        minv[j] -= delta;
                    }
                }
                j0 = j1;
            } while (p[j0] != 0);
            do {
                int j1 = way[j0];
                p[j0] = p[j1];
                j0 = j1;
            } while (j0 != 0);
        }
        return minimize ? -v[0] : v[0];
    }
}