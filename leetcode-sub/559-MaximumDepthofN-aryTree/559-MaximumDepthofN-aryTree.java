// Last updated: 7/25/2025, 9:16:34 PM
class Solution {
    public int maxDepth(Node root) {
        return dfs(root);
    }
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return 1 + max;
    }
}