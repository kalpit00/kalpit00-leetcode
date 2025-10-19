// Last updated: 10/19/2025, 9:13:51 AM
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0, count = 0;
        long sum = 0, max = 0;
        int[] map = new int[100001];
        while (right < n) {
            if (map[nums[right]] > 0) {
                count++; // repeating element, count it
            }
            map[nums[right]]++;
            sum += nums[right];
            right++;
            while (count > 0 || right - left > k) { // invalid window, shrink
                sum -= nums[left];
                if (map[nums[left]] > 1) {
                    count--; // was one of the duplicates, removing it
                }
                map[nums[left]]--;
                left++;
            }
            if (right - left == k && count == 0) { // valid window of len k
                max = Math.max(max, sum); // and no dups, max its sum
            }
        }
        return max;
    }
}