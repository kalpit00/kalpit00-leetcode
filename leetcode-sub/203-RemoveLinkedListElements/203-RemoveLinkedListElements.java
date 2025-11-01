// Last updated: 10/31/2025, 10:01:09 PM
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = head;
        while (head != null && head.val == val) {
            head = head.next;
        }
        newHead = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = newHead;
        ListNode temp = dummy;
        while (temp != null && temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
        }
        return dummy.next;
    }
}