// Last updated: 6/18/2025, 3:03:55 AM
class Solution {
    public int maxStudents(char[][] seats) {
        int m = seats.length, n = seats[0].length, count = 0;        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count += seats[i][j] == '.' ? 1 : 0;
            }
        } // Max Independent Set = Total seats - Maximum Matching
        int maxMatching = hungarian(seats, m, n);
        return count - maxMatching;
    }
    
    private int hungarian(char[][] seats, int m, int n) {
        int count = 0;
        int[][] visited = new int[m][n], match = new int[m][n];        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                match[i][j] = -1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.' && match[i][j] == -1) {
                    int idx = i * n + j;
                    visited[i][j] = idx;
                    count += dfs(seats, i, j, idx, visited, match, m, n);
                }
            }
        }
        return count;
    }
    
    private int dfs(char[][] seats, int i, int j, int idx, 
                   int[][] visited, int[][] match, int m, int n) {
// 6 directions: top-left, left, bottom-left, top-right, right, bottom-right
        int[][] dir = {{-1, -1}, {0, -1}, {1, -1}, {-1, 1}, {0, 1}, {1, 1}};
        for (int[] d : dir) {
            int r = i + d[0], c = j + d[1];
            if (r < 0 || r >= m || c < 0 || c >= n || 
            seats[r][c] != '.' || visited[r][c] == idx) continue;
            visited[r][c] = idx;
            if (match[r][c] == -1 || dfs(seats, match[r][c] / n, 
            match[r][c] % n, idx, visited, match, m, n) == 1) {
                match[r][c] = i * n + j;
                match[i][j] = r * n + c;
                return 1;
            }
        }
        return 0;
    }
}