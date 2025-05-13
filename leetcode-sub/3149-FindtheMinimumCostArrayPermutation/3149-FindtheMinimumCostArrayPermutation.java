// Last updated: 5/13/2025, 2:40:13 PM
class Solution {
    public int[] findPermutation(int[] nums) {
        int n = nums.length, dest = (1 << n) - 1, min = Integer.MAX_VALUE;
        int[][] cost = new int[n][n]; // cost[i][j] = |i - nums[j]|
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Math.abs(i - nums[j]);
            }
        }            
        int[][] dp = new int[1 << n][n], parent = new int[1 << n][n];
        List<Integer>[][] paths = new ArrayList[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                paths[i][j] = new ArrayList<>();
            }
        }
        paths[1 << 0][0].add(0);
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] row : parent) Arrays.fill(row, -1);
        dp[1 << 0][0] = 0;
        for (int mask = 0; mask <= dest; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 || dp[mask][u] == Integer.MAX_VALUE) 
                    continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    List<Integer> nextPath = new ArrayList<>(paths[mask][u]);
                    nextPath.add(v);
                    int nextMask = mask | (1 << v);
                    int nextCost = dp[mask][u] + cost[u][v];
                    if (nextCost < dp[nextMask][v] || (nextCost == dp[nextMask][v] && helper(nextPath, paths[nextMask][v]))) {
                        dp[nextMask][v] = nextCost;
                        parent[nextMask][v] = u;
                        paths[nextMask][v] = nextPath;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[dest][i] == Integer.MAX_VALUE) continue;
            List<Integer> path = new ArrayList<>();
            int last = i, mask = dest;
            while (last != -1) {
                path.add(last);
                int prev = parent[mask][last];
                mask ^= (1 << last);
                last = prev;
            }
            Collections.reverse(path);
            int score = dp[dest][i] + cost[i][path.get(0)];
            if (score < min || (score == min && helper(path, res))) {
                min = score;
                res = path;
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    } 
    // return if perm 'a' is lexicographically smaller than 'b'
    private boolean helper(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return false;
    }
}
