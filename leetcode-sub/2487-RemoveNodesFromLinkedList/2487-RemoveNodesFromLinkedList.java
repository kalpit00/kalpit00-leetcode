// Last updated: 10/31/2025, 11:32:36 PM
class Solution {
    public ListNode removeNodes(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head, dummy = new ListNode(-1), curr = dummy;
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int n = list.size(), top = -1;
        int[] stack = new int[n], NGE = new int[n];
        Arrays.fill(NGE, -1);
        for (int i = 0; i < n; i++) {
            while (top != -1 && list.get(stack[top]).val < list.get(i).val) {
                int idx = stack[top--];
                NGE[idx] = i;
            }
            stack[++top] = i;
        }
        for (int i = 0; i < n; i++) {
            if (NGE[i] == -1) {
                curr.next = list.get(i);
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
