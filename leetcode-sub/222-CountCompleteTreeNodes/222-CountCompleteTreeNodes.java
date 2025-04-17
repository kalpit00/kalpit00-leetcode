// Last updated: 4/17/2025, 1:37:07 PM
class Solution {
    public int countNodes(TreeNode root) {
        return postorder(root);
    }
    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = postorder(root.left);
        int right = postorder(root.right);
        return 1 + left + right;
    }
}