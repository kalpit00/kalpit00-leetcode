// Last updated: 11/17/2026, 1:57:14 PM
1class Solution {
2    int res = 0;
3    public int countDominantNodes(TreeNode root) {
4        helper(root);
5        return res;
6    }
7    private int helper(TreeNode root) {
8        if (root == null) {
9            return 0;
10        }
11        int left = helper(root.left);
12        int right = helper(root.right);
13        int max = Math.max(root.val, Math.max(left, right));
14        res += max == root.val ? 1 : 0;
15        return max;
16    }
17}