// Last updated: 4/10/2025, 1:20:00 PM
public class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int num) {
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            return;
        }
        if (root.left != null) {
            helper(root.left, num);
        }
        if (root.right != null) {
            helper(root.right, num);
        }
    }
}