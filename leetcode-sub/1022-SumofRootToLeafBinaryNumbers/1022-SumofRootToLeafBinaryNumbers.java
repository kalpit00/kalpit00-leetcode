// Last updated: 2/23/2026, 7:02:40 PM
1class Solution {
2    int sum = 0;
3    public int sumRootToLeaf(TreeNode root) {
4        dfs(root, 0);
5        return sum;
6    }
7
8    private void dfs(TreeNode node, int path) {
9        if (node == null) {
10            return;
11        }
12        path <<= 1;
13        path |= node.val;
14        if (node.left == null && node.right == null) {
15            sum += path;
16        } 
17        dfs(node.left, path);
18        dfs(node.right, path);
19    }
20}
21