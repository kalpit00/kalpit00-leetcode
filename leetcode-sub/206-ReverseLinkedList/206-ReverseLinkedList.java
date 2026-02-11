// Last updated: 2/11/2026, 3:35:06 PM
1class Solution {
2    public ListNode reverseList(ListNode head) {
3        // if (head == null) return head;
4        ListNode prev = null;
5        ListNode curr = head;
6        while (curr != null) {
7            ListNode next = curr.next;
8            curr.next = prev;
9            prev = curr;
10            curr = next;
11        }
12        // head.next = curr;
13        return prev;
14    }
15}