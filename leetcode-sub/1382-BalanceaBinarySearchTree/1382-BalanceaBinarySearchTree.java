// Last updated: 2/8/2026, 8:56:45 PM
1class Solution {
2    public TreeNode balanceBST(TreeNode root) {
3        List<Integer> list = new ArrayList<>();
4        inorder(root, list);
5        return helper(list, 0, list.size() - 1);
6    }
7    private void inorder(TreeNode root, List<Integer> list) {
8        if (root == null) {
9            return;
10        }
11        inorder(root.left, list);
12        list.add(root.val);
13        inorder(root.right, list);
14    }
15    private TreeNode helper(List<Integer> list, int start, int end) {
16        if (start > end) {
17            return null;
18        }
19        int mid = start + (end - start)/2;
20        TreeNode left = helper(list, start, mid - 1);
21        TreeNode right = helper(list, mid + 1, end);
22        TreeNode node = new TreeNode(list.get(mid), left, right);
23        return node;
24    }
25}