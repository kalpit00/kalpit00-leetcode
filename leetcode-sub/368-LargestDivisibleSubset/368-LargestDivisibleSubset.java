// Last updated: 4/6/2025, 4:53:33 AM
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 1, maxIndex = 0;
        Arrays.sort(nums);
        int[] lds = new int[n];
        List<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lds[i] = 1;
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && lds[i] < 1 + lds[j]) {
                    lds[i] = 1 + lds[j];
                    dp[i] = new ArrayList<>(dp[j]); //deep copy use NEW keyword
                    dp[i].add(nums[i]);
                }
            }
            if (lds[i] > max) {
                max = lds[i];
                maxIndex = i;
            }
        }
        return dp[maxIndex];
    }
}
