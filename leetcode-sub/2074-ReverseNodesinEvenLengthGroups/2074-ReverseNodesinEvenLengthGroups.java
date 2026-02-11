// Last updated: 2/11/2026, 3:23:35 PM
1class Solution {
2    public ListNode reverseEvenLengthGroups(ListNode head) {
3        int n = 0, i = 1;
4        ListNode temp = head, prev = null, curr = head;
5        while (temp != null) {
6            temp = temp.next;
7            n++;
8        }
9        while (curr != null && n > 0) {
10            int k = Math.min(i, n);
11            if (k % 2 == 0) {
12                ListNode ans = reverse(curr, k);
13                prev.next = ans;
14                prev = curr;
15                curr = curr.next;
16            }
17            else {
18                for (int j = 0; j < k; j++) {
19                    prev = curr;
20                    curr = curr.next;
21                }
22            }
23            n -= k;
24            i++;
25        }
26        return head;
27    }
28    private ListNode reverse(ListNode head, int k) {
29        ListNode prev = null, curr = head;
30        for (int i = 0; i < k && curr != null; i++) {
31            ListNode next = curr.next;
32            curr.next = prev;
33            prev = curr;
34            curr = next;
35        }
36        head.next = curr;
37        return prev;
38    }
39}