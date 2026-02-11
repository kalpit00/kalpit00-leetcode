// Last updated: 2/11/2026, 3:58:32 PM
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
13            temp = curr;
14            ListNode ans = reverse(temp, k);
15            prev.next = ans;
16            prev = temp;
17            curr = temp.next;
18            n -= k;
19        }
20        return dummy.next;   
21    }
22    private ListNode reverse(ListNode head, int k) {
23        ListNode prev = null, curr = head;
24        for (int i = 0; i < k && curr != null; i++) {
25            ListNode next = curr.next;
26            curr.next = prev;
27            prev = curr;
28            curr = next;
29        }
30        head.next = curr;
31        return prev;
32    }
33}