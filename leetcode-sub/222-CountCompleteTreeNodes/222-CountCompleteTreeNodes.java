// Last updated: 7/28/2025, 11:52:08 PM
class Solution { // O(N) process all Nodes counting each
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}