// Last updated: 5/6/2026, 1:00:11 AM
1class Solution {
2    public char[][] rotateTheBox(char[][] box) {
3        int m = box.length, n = box[0].length;
4        char[][] result = new char[n][m];
5        for (int i = 0; i < n; i++) {
6            for (int j = 0; j < m; j++) {
7                result[i][j] = '.';
8            }
9        }
10// gravity lets stones fall to the lowest possible empty cell in each column
11        for (int i = 0; i < m; i++) {
12            int lowestRowWithEmptyCell = n - 1;
13            // Process each cell in row `i` in reversed order
14            for (int j = n - 1; j >= 0; j--) {
15                // Found a stone - let it fall to the lowest empty cell
16                if (box[i][j] == '#') {
17                    // Place it in the correct position in the rotated grid
18                    result[lowestRowWithEmptyCell][m - i - 1] = '#';
19                    lowestRowWithEmptyCell--;
20                }
21                // Found an obstacle - reset `lowestRowWithEmptyCell` to the row directly above it
22                if (box[i][j] == '*') {
23                    // Place the obstacle in the correct position in the rotated grid
24                    result[j][m - i - 1] = '*';
25                    lowestRowWithEmptyCell = j - 1;
26                }
27            }
28        }
29        return result;
30    }
31}
32