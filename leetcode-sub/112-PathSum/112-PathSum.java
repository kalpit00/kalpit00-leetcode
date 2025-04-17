// Last updated: 4/17/2025, 3:12:25 AM
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode node, int sum, int targetSum) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (node.left == null && node.right == null && sum == targetSum) {
            return true;
        }
        boolean left = dfs(node.left, sum, targetSum);
        boolean right = dfs(node.right, sum, targetSum);
        return left || right;
    }
}