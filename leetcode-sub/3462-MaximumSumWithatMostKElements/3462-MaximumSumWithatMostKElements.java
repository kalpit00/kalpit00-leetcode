// Last updated: 5/2/2025, 9:34:28 PM
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
            int limit = grid[i].length - limits[i];
            for (int j = grid[i].length - 1; j >= limit; j--) {
                list.add(grid[i][j]);
            }
        }

        list.sort(Comparator.reverseOrder());

        long sum = 0L;
        for (int i = 0; i < k; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}