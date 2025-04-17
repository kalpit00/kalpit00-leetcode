// Last updated: 4/17/2025, 1:42:34 AM
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode intersect = intersection(head);
        if (intersect == null) {
            return null; // no cycles found as intersection pt is null!
        }
        ListNode start = head;
        while (intersect != start) {
            intersect = intersect.next;
            start = start.next;
        }
        return start;
    }
    public ListNode intersection(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return slow; // or fast, both are same node at intersection pt
            }
        }    
        return null;
    }
}