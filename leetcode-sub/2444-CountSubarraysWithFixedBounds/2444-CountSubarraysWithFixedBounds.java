// Last updated: 5/10/2025, 3:41:29 AM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, left = 0, right = 0;
        long count = 0;
        Queue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        while (right < n) {
            while (!maxHeap.isEmpty() && maxHeap.peek()[1] <= nums[right]) {
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && minHeap.peek()[1] >= nums[right]) {
                minHeap.poll();
            }
            maxHeap.add(new int[]{right, nums[right]});
            minHeap.add(new int[]{right, nums[right]});
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
                minHeap.clear();
                maxHeap.clear();
            } 
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && 
            minHeap.peek()[1] == minK && maxHeap.peek()[1] == maxK) {  
                count += Math.min(maxHeap.peek()[0], minHeap.peek()[0]) - left + 1;
            }
            right++;
        }
        return count;
    }
}