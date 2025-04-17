// Last updated: 4/17/2025, 2:22:31 AM
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> prevLevel= new ArrayList<>();
        prevLevel.add(root.val);
        boolean oddLevel = false;
        while (!queue.isEmpty()) {
            int size = queue.size(), idx = 0;
            List<Integer> currLevel= new ArrayList<>();
            Collections.reverse(prevLevel);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (oddLevel) {
                    node.val = prevLevel.get(idx++);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    currLevel.add(node.left.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    currLevel.add(node.right.val);
                }
            }
            prevLevel = currLevel;
            oddLevel = !oddLevel;
        }
        return root;
    }
}