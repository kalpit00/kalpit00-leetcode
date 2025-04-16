// Last updated: 4/15/2025, 11:59:00 PM
class Solution {
    int max = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return max;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};   
        } // {min, max, sum} tuples
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (!(left != null && right != null && 
        root.val > left[1] && root.val < right[0])) {
            return null; // if not BST, return null
        }
        // the root's key must greater than maximum keys of the left subtree
        // the root's key must lower than minimum keys of the right subtree
        int sum = root.val + left[2] + right[2];
        max = Math.max(max, sum);
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);
        return new int[]{min, max, sum};
    }
}