// Last updated: 5/26/2025, 4:58:55 AM
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        k = k % n;
        if (k == 0) return head;
        head = reverseBetween(head, 1, n);
        head = reverseBetween(head, 1, k);
        head = reverseBetween(head, k + 1, n);
        return head;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1), prev = dummy;
        dummy.next = head;
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
