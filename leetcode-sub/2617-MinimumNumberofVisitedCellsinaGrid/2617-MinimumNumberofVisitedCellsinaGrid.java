// Last updated: 4/8/2026, 2:40:36 AM
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int [][]maxRow = new int[M][N];
        int [][]maxCol = new int[M][N];

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{0, 0});
        int minVisits = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            while(size-- > 0) {
                int []cur = que.remove();
                int r = cur[0], c = cur[1], cellVal = grid[r][c];
                if(r == M-1 && c == N-1)
                    return minVisits + 1;

                for(int k = r + 1; k <= r + cellVal && k < M; k++) {
                    if(maxRow[k][c] == 0) {
                        maxRow[k][c] = cellVal + r;
                        que.add(new int[]{k, c});
                    } else {
                        k = maxRow[k][c]; // skip till max row, if already evaluted before
                    }
                }

                for(int k = c + 1; k <= c + cellVal && k < N; k++) {
                    if(maxCol[r][k] == 0) {
                        maxCol[r][k] = cellVal + c;
                        que.add(new int[]{r, k});
                    } else {
                        k = maxCol[r][k]; // skip till max col, if already evaluted before
                    }
                }
            }
            minVisits++;
        }
        return -1;
    }
}