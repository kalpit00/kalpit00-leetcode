// Last updated: 6/11/2026, 9:17:39 PM
1class Solution { // logN * logN
2    public int countNodes(TreeNode root) {
3        if (root == null) {
4            return 0;
5        }
6        int left = depth(root, true), right = depth(root, false);
7        if (left == right) { // its complete BT, there are 2^h - 1 nodes
8            return (1 << left) - 1;
9        } // else, using normal O(N) dfs to count
10        return 1 + countNodes(root.left) + countNodes(root.right);
11    }
12    
13    public int depth(TreeNode root, boolean isLeft) {
14        int count = 0;
15        while (root != null) {
16            count++;
17            root = isLeft ? root.left : root.right;
18        }
19        return count;
20    }
21}