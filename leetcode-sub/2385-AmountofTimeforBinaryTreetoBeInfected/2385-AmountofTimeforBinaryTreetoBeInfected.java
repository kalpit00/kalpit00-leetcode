// Last updated: 8/4/2026, 10:40:28 PM
1class Solution {
2    int max = 0;
3    public int amountOfTime(TreeNode root, int start) {
4        dfs(root, start);
5        return max;
6    }
7
8    public int dfs(TreeNode root, int start) {
9        if (root == null) {
10            return 0;
11        }
12        int depth = 0;
13        int left = dfs(root.left, start);
14        int right = dfs(root.right, start);
15        if (root.val == start) {
16            max = Math.max(left, right);
17            depth = -1;
18        } else if (left >= 0 && right >= 0) {
19            depth = Math.max(left, right) + 1;
20        } else {
21            int sum = Math.abs(left) + Math.abs(right);
22            max = Math.max(max, sum);
23            depth = Math.min(left, right) - 1;
24        }
25        return depth;
26    }
27}