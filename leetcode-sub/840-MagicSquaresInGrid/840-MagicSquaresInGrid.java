// Last updated: 12/29/2025, 11:22:41 PM
1class Solution {
2    public int numMagicSquaresInside(int[][] grid) {
3        int count = 0;
4        int rows = grid.length;
5        int cols = grid[0].length;
6
7        for (int i = 0; i <= rows - 3; i++) {
8            for (int j = 0; j <= cols - 3; j++) {
9                if (isMagicSquare(grid, i, j)) {
10                    count++;
11                }
12            }
13        }
14
15        return count;
16    }
17
18    private boolean isMagicSquare(int[][] grid, int row, int col) {
19        int[] counts = new int[10];
20
21        // Check if all numbers are distinct and in the range 1 to 9
22        for (int i = 0; i < 3; i++) {
23            for (int j = 0; j < 3; j++) {
24                int num = grid[row + i][col + j];
25                if (num < 1 || num > 9 || counts[num] > 0) {
26                    return false;
27                }
28                counts[num]++;
29            }
30        }
31
32        // Check rows, columns, and diagonals
33        int sum = grid[row][col] + grid[row][col + 1] + grid[row][col + 2];
34        for (int i = 1; i < 3; i++) {
35            int rowSum = grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2];
36            int colSum = grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i];
37            if (rowSum != sum || colSum != sum) {
38                return false;
39            }
40        }
41
42        int diagonalSum = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
43        int antiDiagonalSum = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
44        return diagonalSum == sum && antiDiagonalSum == sum;
45    }
46}
47