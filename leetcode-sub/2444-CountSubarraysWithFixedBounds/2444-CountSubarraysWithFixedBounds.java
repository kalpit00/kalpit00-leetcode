// Last updated: 4/25/2025, 9:56:57 PM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, left = 0, right = 0;
        long count = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();   
        while (right < n) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            maxDeque.add(right);
            minDeque.add(right);
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1;
                minDeque.clear();
                maxDeque.clear();
            }
            if (!minDeque.isEmpty() && !maxDeque.isEmpty() && nums[minDeque.peekFirst()] == minK && nums[maxDeque.peekFirst()] == maxK) {  
                count += Math.min(maxDeque.peekFirst(), minDeque.peekFirst()) - left + 1;
            }
            right++;
        }
        return count;
    }
}