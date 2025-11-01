// Last updated: 10/31/2025, 10:38:45 PM
class Solution {
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.val < temp.val) { // instead of checking next==val
                temp.next = temp.next.next; // check if its < curr.val!
            }
            else {
                temp = temp.next;
            }
        }
        return reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}