// Last updated: 4/4/2025, 3:11:08 AM
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode[] leaves = new TreeNode[2];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                leaves[0] = i == 0 ? node : leaves[0];
                leaves[1] = i == size - 1 ? node : leaves[1];
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return lca(root, leaves[0], leaves[1]);
    }

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}