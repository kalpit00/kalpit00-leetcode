// Last updated: 8/27/2025, 8:09:43 PM
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; i + j < n; j++) {
                list.add(grid[i + j][j]);
            }
            list.sort(Collections.reverseOrder());
            for (int j = 0; i + j < n; j++) {
                grid[i + j][j] = list.get(j);
            }
        }
        for (int j = 1; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; j + i < n; i++) {
                list.add(grid[i][j + i]);
            }
            Collections.sort(list);
            for (int i = 0; j + i < n; i++) {
                grid[i][j + i] = list.get(i);
            }
        }
        return grid;
    }
}