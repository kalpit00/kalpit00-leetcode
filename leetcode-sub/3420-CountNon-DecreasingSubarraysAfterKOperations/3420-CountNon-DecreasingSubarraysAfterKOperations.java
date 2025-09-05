// Last updated: 9/5/2025, 1:01:33 PM
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    // Node class to store the count of element equal to num and the current element value
    class Node {
        long count;
        int num;

        public Node(long count, int num) {
            this.count = count;
            this.num = num;
        }
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Deque to maintain elements with their count in a non-increasing order
        Deque<Node> deque = new ArrayDeque<>();

        // Start by considering the last element as size of 1
        deque.offer(new Node(1, nums[n - 1]));

        long result = 1; // Initialize result with 1, as the last element always forms a subarray of length 1
        long operation = 0; // This keeps track of the operations needed to make the subarray non-decreasing
        int eligibleElement = 1; // The number of elements eligible for forming non-decreasing subarrays, the last element is included

        // Traverse the array from second last element to the first
        for (int i = n - 2; i >= 0; i--) {
            Node node = new Node(1, nums[i]); // Start by considering the current element as a subarray of size 1

            // Check if the current element is greater than or equal to any previous element
            // If so, we need to make the previous elements equal to the current element
            while (!deque.isEmpty() && deque.peek().num <= nums[i]) {
                // Remove the elements that need to be made equal to the current element
                Node prev = deque.poll();

                // Update the count of the current node by adding the count of previous nodes
                node.count += prev.count;

                // Update the total operations needed to make the subarrays non-decreasing
                operation += (node.num - prev.num) * prev.count;
            }

            eligibleElement++; // Increase the count of eligible elements that can form subarrays
            deque.offerFirst(node); // Add the current element to the deque

            // If the number of operations exceeds 'k', remove elements from the back of the deque
            // to shrink the window until the operation count is within the allowed limit
            while (operation > k) {
                eligibleElement--; // Decrease the eligible element count
                operation -= (deque.peekLast().num - nums[i + eligibleElement]); // Adjust operation by removing the last element

                // If the last element count becomes 0, remove it from the deque
                if (--deque.peekLast().count == 0) {
                    deque.pollLast();
                }
            }

            result += eligibleElement;
        }

        return result;
    }
}