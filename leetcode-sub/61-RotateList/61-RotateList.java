// Last updated: 5/4/2026, 10:07:50 PM
1class Solution {
2    public ListNode rotateRight(ListNode head, int k) {
3        if (head == null || head.next == null || k == 0) {
4            return head;
5        }
6        int n = 0;
7        ListNode temp = head;
8        while (temp != null) {
9            n++;
10            temp = temp.next;
11        }
12        k = k % n;
13        if (k == 0) return head;
14        head = reverseBetween(head, 1, n);
15        head = reverseBetween(head, 1, k);
16        head = reverseBetween(head, k + 1, n);
17        return head;
18    }
19
20    public ListNode reverseBetween(ListNode head, int left, int right) {
21        if (head == null || left == right) {
22            return head;
23        }
24        ListNode dummy = new ListNode(-1), prev = dummy;
25        dummy.next = head;
26        for (int i = 1; i < left; i++) {
27            prev = prev.next;
28        }
29        ListNode curr = prev.next, after = curr;
30        for (int i = left; i <= right; i++) {
31            after = after.next;
32        }
33        ListNode ans = reverseList(curr, after);
34        prev.next = ans;
35        curr.next = after;
36        return dummy.next;
37    }
38
39    public ListNode reverseList(ListNode head, ListNode after) {
40        ListNode prev = null, curr = head;
41        while (curr != after) {
42            ListNode next = curr.next;
43            curr.next = prev;
44            prev = curr;
45            curr = next;
46        }
47        return prev;
48    }
49}
50