// Last updated: 7/28/2025, 11:56:56 PM
class Solution { // logN * logN
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root, true), right = depth(root, false);
        if (left == right) { // its complete BT, there are 2^(h + 1) - 1 nodes
            return (1 << left + 1) - 1;
        } // else, using normal O(N) dfs to count
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int depth(TreeNode root, boolean isLeft) {
        int count = -1;
        while (root != null) {
            count++;
            root = isLeft ? root.left : root.right;
        }
        return count;
    }
}