// Last updated: 4/17/2025, 12:11:27 PM
class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left); // recurse on left subtree
        int right = dfs(node.right); // recurse on right subtree
        return 1 + Math.max(left, right); // join answers with root node
    }
}