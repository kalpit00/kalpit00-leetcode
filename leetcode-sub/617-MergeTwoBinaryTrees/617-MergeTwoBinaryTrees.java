// Last updated: 7/14/2025, 1:52:52 PM
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.offer(new TreeNode[] {root1, root2});
        while (!queue.isEmpty()) {
            TreeNode[] nodes = queue.poll();
            TreeNode node1 = nodes[0], node2 = nodes[1];
            node1.val += node2.val;
            if (node1.left == null) {
                node1.left = node2.left;
            }
            else if (node2.left != null) {
                queue.offer(new TreeNode[] { node1.left, node2.left });
            }
            if (node1.right == null) {
                node1.right = node2.right;
            }
            else if (node2.right != null) {
                queue.offer(new TreeNode[] { node1.right, node2.right });
            }
        }
        return root1;
    }
}
