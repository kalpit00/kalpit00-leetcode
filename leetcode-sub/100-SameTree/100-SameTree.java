// Last updated: 4/17/2025, 1:42:19 PM
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return postorder(p, q);
    }
    private boolean postorder(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        boolean left = postorder(p.left, q.left);
        boolean right = postorder(p.right, q.right);
        return left && right && p.val == q.val;
    }
}