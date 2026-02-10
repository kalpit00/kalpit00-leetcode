// Last updated: 2/10/2026, 4:08:27 PM
1class Solution {
2    public ListNode reverseEvenLengthGroups(ListNode head) {
3        ListNode prev = head;
4        int i = 2;
5        while (prev.next != null) {
6            ListNode temp = prev.next;
7            int j = 0;
8            while (j < i && temp != null) {
9                j++;
10                temp = temp.next;
11            }            
12            if (j % 2 == 0) {
13                prev.next = reverse(prev.next, j);
14            }            
15            for (int k = 0; k < j; k++) {
16                prev = prev.next;
17            }
18            i++;
19        }
20        return head;
21    }
22    private ListNode reverse(ListNode head, int count) {
23        ListNode prev = null, curr = head;
24        for (int i = 0; i < count; i++) {
25            ListNode next = curr.next;
26            curr.next = prev;
27            prev = curr;
28            curr = next;
29        }
30        head.next = curr;
31        return prev;
32    }
33}