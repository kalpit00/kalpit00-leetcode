// Last updated: 1/9/2026, 10:15:52 AM
1class Solution {
2    public TreeNode subtreeWithAllDeepest(TreeNode root) {
3        Queue<TreeNode> queue = new LinkedList<>();
4        queue.offer(root);
5        TreeNode[] leaves = new TreeNode[2];
6        while (!queue.isEmpty()) {
7            int size = queue.size();
8            for (int i = 0; i < size; i++) {
9                TreeNode node = queue.poll();
10                if (i == 0) {
11                    leaves[0] = node;
12                }
13                if (i == size - 1) {
14                    leaves[1] = node;
15                }
16                if (node.left != null) {
17                    queue.offer(node.left);
18                }
19                if (node.right != null) {
20                    queue.offer(node.right);
21                }
22            }
23        }
24        return lca(root, leaves[0], leaves[1]);
25    }
26
27    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
28        if (root == null || root == p || root == q) {
29            return root;
30        }
31        TreeNode left = lca(root.left, p, q);
32        TreeNode right = lca(root.right, p, q);
33        return left == null ? right : right == null ? left : root;
34    }
35    
36}
37