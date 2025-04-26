// Last updated: 4/25/2025, 10:07:36 PM
class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length, left = 0, right = 0;
        long count = 0;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();   
        while (right < n) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            } // monodeque steps to carry max and mins on peek
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            } // offer INDICES for max and min elements, NOT elements
            maxDeque.add(right);
            minDeque.add(right);
// if curr ele is outside of range [minK, maxK], ALL eles in between invalid
            if (nums[right] < minK || nums[right] > maxK) {
                left = right + 1; // move left to right + 1
                minDeque = new ArrayDeque<>(); // start fresh deques!
                maxDeque = new ArrayDeque<>();
            } // SHRINK left step, no need for WHILE, a one-shot IF suffices
            if (!minDeque.isEmpty() && !maxDeque.isEmpty() && nums[minDeque.peekFirst()] == minK && nums[maxDeque.peekFirst()] == maxK) {  
                count += Math.min(maxDeque.peekFirst(), minDeque.peekFirst()) - left + 1; // same as doing count += (right - left)
            } // except right = Math.min(max.peek, min.peek)
            right++;
        } // and we do right++ AFTER 2nd while, so count += right - left + 1
        return count;
    }
}