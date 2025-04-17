// Last updated: 4/17/2025, 1:52:59 AM
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int n = 1; // start with len = 1 because we stop at second last node!
        ListNode temp = head;
        while (temp.next != null) {
            n++; // STOP at last/tail node, don't let temp become null!
            temp = temp.next; 
        } // thats why use temp.next != null, not temp != null!
        k = k % n;
        if (k == 0) {
            return head;
        } // make circular LinkedList FIRST!
        temp.next = head; // link tail of og list to head. its a cycle now
        temp = head; // reset temp to move till (n - k)th node
        for (int i = 1; i < n - k; i++) {
            temp = temp.next;
        } // move a ptr 'n - k - 1' steps, as the 'n - k'th node is our res!
        ListNode resHead = temp.next; // the next node of this is our reshead
        temp.next = null; // disconnect here. delete the n-k-1 to 'n-k'th edge
        return resHead;
    }
}
