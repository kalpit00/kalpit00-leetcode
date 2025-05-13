// Last updated: 5/13/2025, 2:58:03 PM
class Solution {
    public int[] findPermutation(int[] nums) {
        int n = nums.length, dest = (1 << n) - 1, min = Integer.MAX_VALUE;
        int[][] cost = new int[n][n]; // cost[i][j] = |i - nums[j]|
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Math.abs(i - nums[j]);
            }
        }
        Node[][] dp = new Node[1 << n][n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new Node();
            }
        }
        dp[1 << 0][0].path.add(0);
        dp[1 << 0][0].cost = 0;
        for (int mask = 0; mask <= dest; mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0 || 
                        dp[mask][u].cost == Integer.MAX_VALUE) 
                    continue;
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue;
                    List<Integer> nextPath = new ArrayList<>(dp[mask][u].path);
                    nextPath.add(v);
                    int nextMask = mask | (1 << v);
                    int nextCost = dp[mask][u].cost + cost[u][v];
                    if (nextCost < dp[nextMask][v].cost || (nextCost == dp[nextMask][v].cost && helper(nextPath, dp[nextMask][v].path))) {
                        dp[nextMask][v].cost = nextCost;
                        dp[nextMask][v].parent = u;
                        dp[nextMask][v].path = nextPath;
                    }
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dp[dest][i].cost == Integer.MAX_VALUE) continue;
            List<Integer> path = new ArrayList<>();
            int last = i, mask = dest;
            while (last != -1) {
                path.add(last);
                int prev = dp[mask][last].parent;
                mask ^= (1 << last);
                last = prev;
            }
            Collections.reverse(path);
            int score = dp[dest][i].cost + cost[i][path.get(0)];
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
    class Node {
        int cost, parent;
        List<Integer> path;
        public Node() {
            cost = Integer.MAX_VALUE;
            parent = -1;
            path = new ArrayList<>();
        }
    }
}
