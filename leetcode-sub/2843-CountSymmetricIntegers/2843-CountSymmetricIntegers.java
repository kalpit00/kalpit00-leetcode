// Last updated: 4/10/2025, 11:20:46 PM
class Solution {
    public int countSymmetricIntegers(int low, int high) {
        // Convert to strings to make digit access easier
        String lowStr = String.valueOf(low - 1);
        String highStr = String.valueOf(high);
        
        // Count symmetric integers up to high
        int countHigh = countSymmetric(highStr);
        
        // Count symmetric integers up to low-1
        int countLow = countSymmetric(lowStr);
        
        return countHigh - countLow;
    }
    
    private int countSymmetric(String num) {
        int n = num.length();
        // dp[pos][leadingZeros][symmetrySum]
        Integer[][][] dp = new Integer[n][n + 1][200]; // Offset symSum by 100
        
        return dfs(num, 0, true, true, 0, 0, dp);
    }
    
    private int dfs(String target, int pos, boolean isLimit, boolean isLeadingZeros, 
                    int lenLeadingZeros, int symmetrySum, Integer[][][] dp) {
        // Base case: we've processed all digits
        if (pos == target.length()) {
            // Check if number has even digits (after removing leading zeros) and is symmetric
            return (pos - lenLeadingZeros > 0 && (pos - lenLeadingZeros) % 2 == 0 && symmetrySum == 0) ? 1 : 0;
        }
        
        // Early termination: if we have odd number of non-zero digits, we can't form a symmetric integer
        if (!isLeadingZeros && (target.length() - lenLeadingZeros) % 2 != 0) {
            return 0;
        }
        
        // Use memoization if possible
        if (!isLeadingZeros && !isLimit && dp[pos][lenLeadingZeros][symmetrySum + 100] != null) {
            return dp[pos][lenLeadingZeros][symmetrySum + 100];
        }
        
        int count = 0;
        
        // Handle continuing leading zeros
        if (isLeadingZeros) {
            count += dfs(target, pos + 1, false, true, lenLeadingZeros + 1, symmetrySum, dp);
        }
        
        // Determine the range of digits we can use at this position
        int low = isLeadingZeros ? 1 : 0;
        int high = isLimit ? target.charAt(pos) - '0' : 9;
        
        // Determine if we're in the first half or second half (excluding leading zeros)
        boolean isFirstHalf = pos - lenLeadingZeros < (target.length() - lenLeadingZeros) / 2;
        
        // Try each valid digit
        for (int d = low; d <= high; d++) {
            // Update symmetry sum: add if in first half, subtract if in second half
            int newSymmetrySum = symmetrySum + (isFirstHalf ? d : -d);
            
            // Only proceed if symmetry is still possible
            if (newSymmetrySum >= -100 && newSymmetrySum <= 100) {
                count += dfs(target, pos + 1, 
                           isLimit && d == high, 
                           false, 
                           lenLeadingZeros, 
                           newSymmetrySum, 
                           dp);
            }
        }
        
        // Memoize result if not constrained by limits
        if (!isLeadingZeros && !isLimit) {
            dp[pos][lenLeadingZeros][symmetrySum + 100] = count;
        }
        
        return count;
    }
}