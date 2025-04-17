// Last updated: 4/17/2025, 2:55:39 AM
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        if (node == null) {
            return;
        }
        int len = path.length();
        path.append(node.val);
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } 
        else {
            path.append("->");
            dfs(node.left, path, result);
            dfs(node.right, path, result);
        }
        path.setLength(len);
    }
}
