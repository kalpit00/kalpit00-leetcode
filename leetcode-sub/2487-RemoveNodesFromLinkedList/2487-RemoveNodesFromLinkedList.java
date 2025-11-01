// Last updated: 10/31/2025, 11:03:29 PM
class Solution {
    public ListNode removeNodes(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            while (!stack.isEmpty() && stack.peek().val < temp.val) {
                set.add(stack.pop());
            }
            stack.push(temp);
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