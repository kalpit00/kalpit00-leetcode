// Last updated: 7/30/2025, 4:32:39 PM
class Solution {
    public int[] smallestTrimmedNumbers(String[] arr, int[][] queries) {
        int x = arr[0].length(), n = arr.length, m = queries.length;
        String[][] nums = new String[n][2];
        for (int i = 0; i < n; i++) {
            nums[i] = new String[]{arr[i], String.valueOf(i)};
        }
        int[][] ans = new int[x][n];
        int[] res = new int[m];
        for (int i = x - 1; i >= 0; i--) {
            radixSort(nums, i);
            for (int j = 0; j < n; j++) {
                ans[i][j] = Integer.parseInt(nums[j][1]);
            }
        }
        for (int i = 0; i < m; i++) {
            int k = queries[i][0], trim = queries[i][1];
            res[i] = ans[x - trim][k - 1];
        }
        return res;
    }
    
    private void radixSort(String[][] nums, int k) {
        int n = nums.length;
        int[] map = new int[10];        
        String[][] res = new String[n][2];
        for (int i = 0; i < n; i++) {
            int d = nums[i][0].charAt(k) - '0';
            map[d]++;
        }        
        for (int i = 1; i < 10; i++) {
            map[i] += map[i - 1];
        }        
        for (int i = n - 1; i >= 0; i--) {
            int d = nums[i][0].charAt(k) - '0';
            res[map[d] - 1] = nums[i];
            map[d]--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}