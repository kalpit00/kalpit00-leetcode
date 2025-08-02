// Last updated: 8/2/2025, 7:03:06 PM
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;
        int n = 1; // start with 1 because going till temp.next != null
        while (tail.next != null) {
            n++;
            tail = tail.next;
        }
        return mergeSort(head, tail, 0, n - 1);
    }
    private TreeNode mergeSort(ListNode head, ListNode tail, 
    int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        ListNode slow = head, fast = head, prev = null;
        while (fast != tail && fast.next != tail) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode res = new TreeNode(slow.val);
        res.left = mergeSort(head, prev, start, mid - 1);
        res.right = mergeSort(slow.next, tail, mid + 1, end);
        return res;
    }
}