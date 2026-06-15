// Last updated: 6/15/2026, 5:28:24 AM
1class Solution {
2    public ListNode deleteMiddle(ListNode head) {
3        if (head == null || head.next == null) {
4            return null; // if only 1 node, its mid node
5        } // deleting the only node gives empty LL, so return null
6        ListNode slow = head;
7        ListNode fast = head;
8        ListNode prev = null; // a THIRD ptr hahaha
9        while (fast != null && fast.next != null) {
10            prev = slow; // get prev of slow
11            slow = slow.next;
12            fast = fast.next.next;
13        } // when fast terminates, slow is at mid, prev is just 1 before mid
14        prev.next = slow.next; // essentially skips/deletes mid node
15        return head;
16    }
17}