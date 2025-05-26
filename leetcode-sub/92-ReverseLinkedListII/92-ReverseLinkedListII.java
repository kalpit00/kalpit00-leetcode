// Last updated: 5/25/2025, 11:16:50 PM
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        } 
        ListNode dummy = new ListNode(-1), prev = dummy;
        dummy.next = head; // move prev to 1 node before 'left' index element
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        } // store the 'left' index item at curr (prev.next)
        ListNode curr = prev.next, after = curr;
        for (int i = left; i <= right; i++) {
            after = after.next;
        } // and store the node at 'right' + 1 index item in 'after'
        ListNode ans = reverseList(curr, after); // ans is reversed head!
        prev.next = ans; // connect prev.next to reversed head.
        curr.next = after; // connect tail of reversed LL to 'after'
        return dummy.next;
    }
    // Rev LL1 + 'after' var to rev until a certain node in LL, not till null
    public ListNode reverseList(ListNode head, ListNode after) {
        ListNode prev = null, curr = head;
        while (curr != after) { // curr goes till 'after' node
            ListNode next = curr.next;
            curr.next = prev; 
            prev = curr;
            curr = next;
        } // in classic rev LL1, curr goes till null, so we reversed entire LL!
        return prev;
    }
}
