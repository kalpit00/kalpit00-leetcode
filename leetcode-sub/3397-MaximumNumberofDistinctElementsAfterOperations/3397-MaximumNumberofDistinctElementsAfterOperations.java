// Last updated: 10/17/2025, 8:03:49 PM
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int prev = Integer.MIN_VALUE;
        for (int num : nums) {
            int curr = Math.min(Math.max(num - k, prev + 1), num + k);
            if (curr > prev) {
                cnt++;
                prev = curr;
            }
        }
        return cnt;
    }
}