// Last updated: 2/10/2026, 3:16:39 PM
1class Solution {
2    public ListNode reverseEvenLengthGroups(ListNode head) {
3        ListNode curr = head.next, prev1 = head, res = head, prev2 = null;
4        int i = 2;
5        while (curr != null) {
6            int j = 0;
7            ListNode before = curr;
8            for (int k = 0; k < i && curr != null; k++) {
9                j++;
10                prev2 = curr;
11                curr = curr.next;
12            }
13            ListNode after = curr;
14            if (j % 2 == 0) {
15                ListNode ans = reverseList(before, after);
16                prev1.next = ans;
17                before.next = after;   
18                prev1 = before;
19            }
20            else {
21                prev1 = prev2;
22            }
23            i++;
24        }
25        return res;
26    }
27    public ListNode reverseList(ListNode head, ListNode after) {
28        ListNode prev = null, curr = head;
29        while (curr != after) {
30            ListNode next = curr.next;
31            curr.next = prev; 
32            prev = curr;
33            curr = next;
34        }
35        return prev;
36    }
37}