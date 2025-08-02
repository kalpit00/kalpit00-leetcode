// Last updated: 8/2/2025, 7:15:02 PM
class Solution {
    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        this.head = head;
        ListNode temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        return mergeSort(0, n - 1);
    }
    private TreeNode mergeSort(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode left = mergeSort(start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        head = head.next; // CRUCIAL step
        root.left = left;
        root.right = mergeSort(mid + 1, end);
        return root;
    }
}