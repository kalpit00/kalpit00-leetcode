// Last updated: 10/31/2025, 11:24:38 PM
class Solution {
    public ListNode removeNodes(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        int n = 0, top = -1;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        ListNode[] stack = new ListNode[n];
        while (temp != null) {
            while (top >= 0 && stack[top].val < temp.val) {
                set.add(stack[top--]);
            }
            stack[++top] = temp;
            temp = temp.next;
        }
        while (head != null && set.contains(head)) {
            head = head.next;
        }
        temp = head;
        while (temp != null && temp.next != null) {
            if (set.contains(temp.next)) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}