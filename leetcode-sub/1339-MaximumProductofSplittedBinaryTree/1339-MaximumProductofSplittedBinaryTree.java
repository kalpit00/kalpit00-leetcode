// Last updated: 1/7/2026, 7:57:55 AM
1class Solution {
2    int mod = 1000000007;
3    long max = Long.MIN_VALUE;
4    long total = 0;
5    public int maxProduct(TreeNode root) {
6        inorder(root);
7        dfs(root);
8        return (int) (max % mod);
9    }
10    private void inorder(TreeNode node) {
11        if (node == null) {
12            return;
13        }
14        inorder(node.left);
15        total += node.val;
16        inorder(node.right);
17    }
18    private long dfs(TreeNode node) {
19        if (node == null) {
20            return 0L;
21        }
22        long left = dfs(node.left);
23        long right = dfs(node.right);
24        long sum = node.val + left + right;
25        max = Math.max(max, sum * (total - sum));
26        return sum;
27    }
28}