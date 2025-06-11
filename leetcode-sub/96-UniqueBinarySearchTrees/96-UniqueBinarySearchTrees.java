// Last updated: 6/11/2025, 3:32:11 PM
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
            List<TreeNode[]> pairs = product(left, right);
            for (TreeNode[] pair : pairs) {
                TreeNode curr = new TreeNode(k);
                curr.left = pair[0];
                curr.right = pair[1];
                res.add(curr);
            }
        }
        return dp[i][j] = res;
    }
    private List<TreeNode[]> product(List<TreeNode> left, List<TreeNode> right){
        List<TreeNode[]> list = new ArrayList<>();
        for (TreeNode a: left) {
            for (TreeNode b: right) {
                list.add(new TreeNode[]{deepCopy(a), deepCopy(b)});
            }
        }
        return list;
    }
    private TreeNode deepCopy(TreeNode root) {
        if (root == null) return null;
        TreeNode curr = new TreeNode(root.val);
        curr.left  = deepCopy(root.left);
        curr.right = deepCopy(root.right);
        return curr;
    }
}