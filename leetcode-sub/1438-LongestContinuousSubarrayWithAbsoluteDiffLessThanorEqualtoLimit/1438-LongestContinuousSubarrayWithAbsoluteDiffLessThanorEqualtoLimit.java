// Last updated: 6/9/2025, 12:24:07 AM
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length, left = 0, right = 0, max = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();   
        while (right < n) {
            while (!maxDeque.isEmpty() && 
            nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            while (!minDeque.isEmpty() &&
            nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            maxDeque.add(right);
            minDeque.add(right);
            right++;
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && 
            nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
