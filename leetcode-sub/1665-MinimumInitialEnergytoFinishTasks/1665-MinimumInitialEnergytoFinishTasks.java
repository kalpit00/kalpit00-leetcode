// Last updated: 5/11/2026, 8:07:53 PM
1class Solution {
2    public int minimumEffort(int[][] tasks) {
3        int max = 0;
4        Arrays.sort(tasks, (a, b) -> (a[1] - a[0]) - (b[1] - b[0]));
5        for (int[] task : tasks) {
6            max = Math.max(max + task[0], task[1]);
7        }
8        return max;
9    }
10}