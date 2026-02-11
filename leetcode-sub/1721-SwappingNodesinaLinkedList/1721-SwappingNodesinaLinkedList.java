// Last updated: 2/11/2026, 4:12:41 PM
1class Solution {
2    public ListNode swapNodes(ListNode head, int k) {
3        ListNode dummy = new ListNode();
4        dummy.next = head;
5        ListNode slow = dummy;
6        ListNode fast = dummy;
7        for (int i = 0; i < k; i++) {
8            fast = fast.next;
9        }
10        int val = fast.val;
11        ListNode temp = fast;
12        while (fast != null) {
13            slow = slow.next;
14            fast = fast.next;
15        } 
16        temp.val = slow.val;
17        slow.val = val;
18        return dummy.next;
19    }
20}