// Last updated: 6/11/2025, 3:34:08 PM
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[][] dp = new List[n + 1][n + 1];
        return solve(1, n, dp);
    }
    private List<TreeNode> solve(int i, int j, List<TreeNode>[][] dp) {
        List<TreeNode> res = new ArrayList<>();
        if (i > j) {
            res.add(null);
            return res;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        for (int k = i; k <= j; k++) {
            List<TreeNode> left = solve(i, k - 1, dp);
            List<TreeNode> right = solve(k + 1, j, dp);
            for (TreeNode a : left) {
                for (TreeNode b: right) {
                    TreeNode node = new TreeNode(k);
                    node.left = a;
                    node.right = b;
                    res.add(node);
                }
            }
        }
        return dp[i][j] = res;
    }
}