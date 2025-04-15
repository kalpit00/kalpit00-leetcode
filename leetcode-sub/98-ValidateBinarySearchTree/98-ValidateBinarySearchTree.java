// Last updated: 4/15/2025, 5:44:02 PM
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left, min, root.val);
        boolean right = helper(root.right, root.val, max);
        return left && right && (min == null || root.val > min)
        && (max == null || root.val < max);
    }
}