// Last updated: 6/13/2026, 8:22:00 PM
1class Solution {
2    public int pairSum(ListNode head) {
3        ListNode slow = head, fast = head;
4        while (fast != null && fast.next != null) {
5            slow = slow.next;
6            fast = fast.next.next;
7        }
8        slow = reverseList(slow);
9        fast = head; // redundant, can just use head also
10        int max = Integer.MIN_VALUE;
11        while (slow != null) {
12            max = Math.max(max, slow.val + fast.val);
13            slow = slow.next;
14            fast = fast.next;
15        }
16        return max;
17    }
18    public ListNode reverseList(ListNode head) {
19        ListNode prev = null;
20        ListNode curr = head;
21        while (curr != null) {
22            ListNode next = curr.next;
23            curr.next = prev;
24            prev = curr;
25            curr = next;
26        }
27        return prev;
28    }
29}