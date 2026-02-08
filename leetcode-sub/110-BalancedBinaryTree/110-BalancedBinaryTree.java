// Last updated: 2/7/2026, 10:11:50 PM
1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        if (root == null) {
4            return true;
5        }
6        return maxDepth(root) != -1;
7    }
8    private int maxDepth(TreeNode root) {
9        if (root == null) return 0;
10        int left = maxDepth(root.left);
11        if (left == -1) return -1;
12        int right = maxDepth(root.right);
13        if (right == -1) return -1;
14        if (Math.abs(left - right) > 1) return -1;
15        return 1 + Math.max(left, right);
16    }
17}