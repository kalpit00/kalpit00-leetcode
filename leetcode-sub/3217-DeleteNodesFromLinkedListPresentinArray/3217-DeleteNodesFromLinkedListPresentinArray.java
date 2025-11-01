// Last updated: 10/31/2025, 8:13:22 PM
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] visited = new boolean[100001];
        for (int num : nums) {
            visited[num] = true;
        }
        while (head != null && visited[head.val]) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (visited[temp.next.val]) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}