// Last updated: 7/20/2025, 1:31:39 PM
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        boolean[] visited = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                visited[fronts[i]] = true;
            }
        }
        int min = 9999;
        for (int num : fronts) {
            if (!visited[num]) {
                min = Math.min(min, num);
            }
        }
        for (int num : backs) {
            if (!visited[num]) {
                min = Math.min(min, num);
            }
        }
        return min % 9999;
    }
}