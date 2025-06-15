// Last updated: 6/15/2025, 12:03:33 AM
class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int n = digits.length, sum = 0, count = 0;
        reverseSort(digits);
        Integer[][] dp = new Integer[n + 1][3];
        if (digits[0] == 0) {
            return "0";
        }
        int ans = solve(0, n, 0, digits, dp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int notTake = dp[i + 1][sum % 3] != null ? 
            dp[i + 1][sum % 3] : Integer.MIN_VALUE;
            int take = dp[i + 1][(sum + digits[i]) % 3] != null ? 
            dp[i + 1][(sum + digits[i]) % 3] : Integer.MIN_VALUE;
            if (notTake > 1 + take) {
                continue;
            } 
            else {
                sb.append((char)(digits[i] + '0'));
                sum += digits[i];
                sum %= 3;
            }
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                count++;
            }
        }
        if (sb.length() == count && sb.length() > 0) {
            return "0";
        }
        return sb.toString();
    }
    
    private int solve(int i, int n, int sum, int[] digits, Integer[][] dp) {
        if (i == n) {
            return dp[i][sum] = sum == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[i][sum] != null) {
            return dp[i][sum];
        }
        int take = 1 + solve(i + 1, n, (sum + digits[i]) % 3, digits, dp);
        int notTake = solve(i + 1, n, sum % 3, digits, dp);
        return dp[i][sum] = Math.max(take, notTake);
    }
    
    private void reverseSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, i = 0, j = n - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}