// Last updated: 10/31/2025, 10:02:54 PM
class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        boolean[] visited = new boolean[100001];
        for (int num : nums) {
            visited[num] = true;
        }
        while (head != null && visited[head.val]) {
            head = head.next;
        }
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            if (visited[temp.next.val]) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}