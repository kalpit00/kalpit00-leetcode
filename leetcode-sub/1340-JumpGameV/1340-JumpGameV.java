// Last updated: 2/17/2026, 2:55:59 AM
class Solution {
    int[] dp;
    int n;
    
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        dp = new int[n];
        
        int max = 1;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dfs(arr, i, d));
        }
        
        return max;
    }
    
    private int dfs(int[] arr, int i, int d) {
        if(dp[i] != 0) return dp[i];
        
        int max = 1; // at least itself
        
        // check left
        for(int j = i - 1; j >= Math.max(0, i - d); j--) {
            if(arr[j] >= arr[i]) break; // blocked
            max = Math.max(max, 1 + dfs(arr, j, d));
        }
        
        // check right
        for(int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
            if(arr[j] >= arr[i]) break; // blocked
            max = Math.max(max, 1 + dfs(arr, j, d));
        }
        
        return dp[i] = max;
    }
}
