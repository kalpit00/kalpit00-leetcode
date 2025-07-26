// Last updated: 7/26/2025, 2:07:22 PM
class Solution {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] dp = helper(root);
        return Math.max(dp[0], dp[1]);
    }
    private int[] helper(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(node.left), right = helper(node.right);
        int take = node.val + left[1] + right[1];
        int notTake = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{take, notTake};
    }
}