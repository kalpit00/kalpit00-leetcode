// Last updated: 2/11/2026, 3:18:19 PM
1class Solution {
2    public ListNode reverseEvenLengthGroups(ListNode head) {
3        int n = -1, i = 2;
4        ListNode temp = head, prev = head, curr = head.next;
5        while (temp != null) {
6            temp = temp.next;
7            n++;
8        }
9        while (curr != null && n > 0) {
10            int k = Math.min(i, n);
11            temp = curr;
12            if (k % 2 == 0) {
13                ListNode ans = reverse(temp, k);
14                prev.next = ans;
15                prev = curr;
16                curr = curr.next;
17            }
18            else {
19                for (int j = 0; j < k; j++) {
20                    prev = curr;
21                    curr = curr.next;
22                }
23            }
24            n -= k;
25            i++;
26        }
27        return head;
28    }
29    private ListNode reverse(ListNode head, int k) {
30        ListNode prev = null, curr = head; // use for-k loop instead of while
31        for (int i = 0; i < k && curr != null; i++) {
32            ListNode next = curr.next;
33            curr.next = prev;
34            prev = curr;
35            curr = next;
36        }
37        head.next = curr;
38        return prev;
39    }
40}