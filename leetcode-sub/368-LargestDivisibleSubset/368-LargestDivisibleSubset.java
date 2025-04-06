// Last updated: 4/6/2025, 4:50:25 AM
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 1, maxIndex = 0;
        Arrays.sort(nums);
        int[] dp = new int[n];
        List<Integer>[] prev = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = new ArrayList<>();
            prev[i].add(nums[i]);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    prev[i] = new ArrayList<>(prev[j]);
                    prev[i].add(nums[i]);
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        return prev[maxIndex];
    }
}
