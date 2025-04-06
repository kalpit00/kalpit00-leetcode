// Last updated: 4/6/2025, 4:39:44 AM
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 1, maxIndex = 0;
        Arrays.sort(nums);
        int[] dp = new int[n], prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i; // backtrack from the maxIndex
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = maxIndex; i >= 0; i = prev[i]) {
            list.add(nums[i]);
        }
        return list;
    }
}