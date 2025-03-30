// Last updated: 3/30/2025, 7:26:01 PM
class Solution {
    public long findScore(int[] nums) {
        long sum = 0;
        int n = nums.length;
        int[][] mat = new int[n][2];
        boolean[] visited = new boolean[n + 2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = nums[i];
            mat[i][1] = i + 1;
        }
        Arrays.sort(mat, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int val = mat[i][0], idx = mat[i][1];
            if (!visited[idx]) {
                sum += val;
                visited[idx] = true;
                visited[idx - 1] = true;
                visited[idx + 1] = true;
            }
        }
        return sum;
    }
}