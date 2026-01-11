// Last updated: 1/10/2026, 11:10:45 PM
1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        int m = matrix.length, n = matrix[0].length, max = 0;
4        int[][] grid = new int[m][n];
5        for (int k = 0; k < n; k++) {
6            grid[0][k] = matrix[0][k] == '0' ? 0 : 1;
7        }
8        for (int i = 1; i < m; i++) {
9            for (int j = 0; j < n; j++) {
10                grid[i][j] = matrix[i][j] == '0' ? 0 : grid[i-1][j] + 1;
11            }
12        }
13        for (int i = 0; i < m; i++) {
14            max = Math.max(max, largestRectangleArea(grid[i]));
15        }
16        return max;
17    }
18    public int largestRectangleArea(int[] heights) {
19        int n = heights.length, top = -1, max = 0;
20        int[] stack = new int[n], PSE = new int[n], NSE = new int[n];
21        Arrays.fill(PSE, -1);
22        Arrays.fill(NSE, n);
23        for (int i = 0; i < n; i++) {
24            while (top != -1 && heights[stack[top]] > heights[i]) {
25                int t = stack[top--];
26                NSE[t] = i;
27            }
28            if (top != -1) {
29                PSE[i] = stack[top];
30            }
31            stack[++top] = i; // must do ++top for first iteration when top = -1
32        }
33        for (int i = 0; i < n; i++) {
34            max = Math.max(max, heights[i] * (NSE[i] - PSE[i] - 1));
35        }
36        return max;
37    }
38}