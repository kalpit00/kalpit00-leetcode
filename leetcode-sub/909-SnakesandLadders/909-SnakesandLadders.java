// Last updated: 5/30/2025, 8:48:11 PM
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = convertToArray(board);
        int steps = 0;
        boolean[] visited = new boolean[n * n];
        Queue<Integer> queue = new LinkedList();
        int start = arr[0] > - 1 ? arr[0] - 1 : 0;
        visited[start] = true;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n - 1) {
                    return steps; // top right cell reached
                }
                for (int j = curr + 1; j <= Math.min(curr + 6, n * n - 1); j++) {
                    int next = arr[j] > -1 ? arr[j] - 1 : j;
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public int[] convertToArray(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        return arr;
    }
}