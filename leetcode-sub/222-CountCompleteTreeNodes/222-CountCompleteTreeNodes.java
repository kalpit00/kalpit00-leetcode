// Last updated: 7/29/2025, 12:13:15 AM
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.right, right = root.right;
        int height = 0;
        while (right != null) { // go till right is null
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null && right == null) { // left == right, 2^h - 1
            return (1 << height) + countNodes(root.left);
        }
        return (1 << (height + 1)) + countNodes(root.right);
    }
}