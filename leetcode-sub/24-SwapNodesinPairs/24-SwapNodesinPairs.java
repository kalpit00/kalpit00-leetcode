// Last updated: 2/11/2026, 4:16:27 PM
1class Solution {
2    public ListNode swapPairs(ListNode head) {
3        return reverseKGroup(head, 2);
4    }
5    public ListNode reverseKGroup(ListNode head, int k) {
6        int n = 0;
7        ListNode temp = head, curr = head, dummy = new ListNode(-1);
8        dummy.next = head;
9        ListNode prev = dummy;
10        while (temp != null) {
11            temp = temp.next;
12            n++;
13        }     
14        while (curr != null && n > 0) {
15            if (k > n) break;
16            ListNode ans = reverse(curr, k);
17            prev.next = ans;
18            prev = curr;
19            curr = curr.next;
20            n -= k;
21        }
22        return dummy.next;   
23    }
24    private ListNode reverse(ListNode head, int k) {
25        ListNode prev = null, curr = head;
26        for (int i = 0; i < k && curr != null; i++) {
27            ListNode next = curr.next;
28            curr.next = prev;
29            prev = curr;
30            curr = next;
31        }
32        head.next = curr;
33        return prev;
34    }
35}