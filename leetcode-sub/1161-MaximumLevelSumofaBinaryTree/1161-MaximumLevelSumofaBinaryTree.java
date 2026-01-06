// Last updated: 1/6/2026, 7:45:33 AM
1class Solution {
2    public int maxLevelSum(TreeNode root) {
3        int max = Integer.MIN_VALUE, level = 1, ans = 1;
4        Queue<TreeNode> queue = new LinkedList();
5        queue.offer(root);
6        while (!queue.isEmpty()) {
7            int size = queue.size();
8            int levelSum = 0;
9            for (int i = 0; i < size; i++) {
10                TreeNode node = queue.poll();
11                levelSum += node.val;
12                if (node.left != null) {
13                    queue.offer(node.left);
14                }                
15                if (node.right != null) {
16                    queue.offer(node.right);
17                }
18            }
19            if (levelSum > max) {
20                max = levelSum;
21                ans = level;
22            }
23            level++;
24        }
25        return ans;
26    }
27}