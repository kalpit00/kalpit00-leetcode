// Last updated: 8/25/2025, 2:12:20 PM
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length, idx = 0;
        int[] res = new int[m * n];
        for (int d = 0; d < m + n - 1; d++) {
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int j = d - i;
                if (j >= 0 && j < n) {
                    nums.add(mat[i][j]);
                }
            }
            int s = nums.size();
            for (int k = 0; k < nums.size(); k++) {
                res[idx++] = d % 2 == 0 ? nums.get(s - 1 - k) : nums.get(k);
            }
        }
        return res;
    }
}