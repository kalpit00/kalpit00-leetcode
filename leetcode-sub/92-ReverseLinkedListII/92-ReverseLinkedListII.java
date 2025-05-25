// Last updated: 5/25/2025, 5:42:51 PM
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        } 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next, after = curr;
        for (int i = left; i <= right; i++) {
            after = after.next;
        }
        ListNode ans = reverseList(curr, after);
        prev.next = ans;
        curr.next = after;
        return dummy.next;
    }

    public ListNode reverseList(ListNode head, ListNode after) {
        ListNode prev = null, curr = head;
        while (curr != after) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
