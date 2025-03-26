// Last updated: 3/25/2025, 10:47:43 PM
class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length, start = 1, end = n, ans = -1;
        long k = (long) n * (n + 1) / 2, median = (k + 1) / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (countCompleteSubarrays(nums, mid) >= median) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public long countCompleteSubarrays(int[] nums, int k) {
        int counter = 0, left = 0, right = 0, n = nums.length;
        long count = 0;
        int[] map = new int[100001];
        while (right < n) {
            map[nums[right]]++;
            if (map[nums[right]] == 1) {
                counter++;
            }
            right++;
            while (counter > k) {
                map[nums[left]]--;
                if (map[nums[left]] == 0) {
                    counter--;
                }
                left++;
            }
            count += right - left;
        }
        return count;
    }
}