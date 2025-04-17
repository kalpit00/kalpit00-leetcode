// Last updated: 4/17/2025, 3:08:47 AM
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, list, root, 0, targetSum);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> list, 
        TreeNode root, int sum, int targetSum) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum += root.val;
        if (root.left == null && root.right == null && sum == targetSum) {
            res.add(new ArrayList<>(list));
        }
        dfs(res, list, root.left, sum, targetSum);
        dfs(res, list, root.right, sum, targetSum);
        list.remove(list.size() - 1); // backtrack
    }
}