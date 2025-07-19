// Last updated: 7/19/2025, 12:50:34 PM
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        return kthGreaterElement(nums, 2);
    }
    public int[] kthGreaterElement(int[] nums, int k) {
        int n = nums.length;
        int[] kge = new int[n];
        Arrays.fill(kge, -1);
        ListNode head = new ListNode(); // dummy node!
        ListNode prev, curr; // <idx, val, count of NGE's seen>
        for (int i = 0; i < n; i++) {
            prev = head;
            curr = head.next;
            while (curr != null && nums[i] > curr.val) {
                curr.count++; // increment GE's seen for each curr
                if (curr.count == k) {
                    kge[curr.idx] = nums[i]; // set kth GE for curr = nums[i]
                    prev.next = curr.next; // delete curr! O(1) deletion in LL
                } else {
                    prev = curr; // just keep moving prev to curr
                }
                curr = curr.next; // moving curr node to next in LL
            }
            prev.next = new ListNode(i, nums[i], 0, curr); // add nums[i] to LL
        }
        return kge;
    }
    public class ListNode {
        int idx;
        int val;
        int count;
        ListNode next;
        ListNode() {

        }
        ListNode(int idx, int val, int count, ListNode next) {
            this.idx = idx;
            this.val = val;
            this.count = count;
            this.next = next;
        }
    }
}