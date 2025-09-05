// Last updated: 9/5/2025, 12:57:51 PM
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int K) {
        long k = K * 1L;
        reverseSort(nums);
        long count = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                int r = deque.pollLast();
                int l = deque.isEmpty() ? left - 1 : deque.peekLast();
                k -= 1L * (r - l) * (nums[right] - nums[r]);
            }
            deque.add(right);
            right++;
            while (k < 0) {
                k += nums[deque.peekFirst()] - nums[left];
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }
                left++;
            }
            count += (long) right - left;
        }
        return count;
    }
    private void reverseSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }
}