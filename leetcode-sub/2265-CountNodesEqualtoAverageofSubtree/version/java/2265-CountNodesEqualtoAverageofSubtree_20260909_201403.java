// Last updated: 9/9/2026, 8:14:03 PM
1class Solution {
2    int res = 0;
3    public int averageOfSubtree(TreeNode root) {
4        helper(root);
5        return res;
6    }
7    private int[] helper(TreeNode root) {
8        if (root == null) {
9            return new int[2];
10        }
11        int[] left = helper(root.left);
12        int[] right = helper(root.right);
13        int sum = root.val + left[0] + right[0];
14        int count = 1 + left[1] + right[1];
15        int avg = sum / count;
16        res += avg == root.val ? 1 : 0;
17        return new int[]{sum, count};
18    }
19}