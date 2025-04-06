// Last updated: 4/6/2025, 5:00:52 AM
public class Solution {
    public int lengthOfLIS(int[] nums) {            
        int n = nums.length, max = 1, maxIndex = 0;
        int[] lis = new int[n];
        List<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[i] < 1 + lis[j]) {
                    lis[i] = 1 + lis[j];
                    dp[i] = new ArrayList<>(dp[j]); //deep copy use NEW keyword
                    dp[i].add(nums[i]);
                }
            }
            if (lis[i] > max) {
                max = lis[i];
                maxIndex = i;
            }
        }
        return max;
    }
}