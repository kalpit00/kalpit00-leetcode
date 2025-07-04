// Last updated: 7/4/2025, 12:15:56 AM
import java.util.*;
public class Solution {
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        // Step 1: Calculate maxSum by taking all positive numbers
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) maxSum += nums[i];
            nums[i] = Math.abs(nums[i]); // convert to abs
        }
        // Step 2: Sort the array
        Arrays.sort(nums);
        // Step 3: Min-heap to track next smallest subtractions
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> Long.compare(a.sum, b.sum));
        heap.offer(new Pair(nums[0], 0));
        int count = 1; // We already have the largest (maxSum)
        long res = maxSum;

        while (count < k) {
            Pair current = heap.poll();
            res = maxSum - current.sum; // k-th largest = maxSum - k-th smallest subtraction
            count++;
            if (current.index + 1 < n) {
                // Case 1: Include next element
                heap.offer(new Pair(current.sum + nums[current.index + 1], current.index + 1));
                // Case 2: Replace current element with next
                heap.offer(new Pair(current.sum - nums[current.index] + nums[current.index + 1], current.index + 1));
            }
        }
        return res;
    }
    static class Pair {
        long sum;
        int index;

        public Pair(long sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
