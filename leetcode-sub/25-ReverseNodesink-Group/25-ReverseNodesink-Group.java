// Last updated: 2/11/2026, 4:02:53 PM
1class Solution {
2    public ListNode reverseKGroup(ListNode head, int k) {
3        int n = 0;
4        ListNode temp = head, curr = head, dummy = new ListNode(-1);
5        dummy.next = head;
6        ListNode prev = dummy;
7        while (temp != null) {
8            temp = temp.next;
9            n++;
10        }     
11        while (curr != null && n > 0) {
12            if (k > n) break;
13            ListNode ans = reverse(curr, k);
14            prev.next = ans;
15            prev = curr;
16            curr = curr.next;
17            n -= k;
18        }
19        return dummy.next;   
20    }
21    private ListNode reverse(ListNode head, int k) {
22        ListNode prev = null, curr = head;
23        for (int i = 0; i < k && curr != null; i++) {
24            ListNode next = curr.next;
25            curr.next = prev;
26            prev = curr;
27            curr = next;
28        }
29        head.next = curr;
30        return prev;
31    }
32}