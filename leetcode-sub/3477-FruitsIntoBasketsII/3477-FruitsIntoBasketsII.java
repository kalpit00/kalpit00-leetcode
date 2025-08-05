// Last updated: 8/4/2025, 9:44:06 PM
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[j] && baskets[j] >= fruits[i]) {
                    visited[j] = true;
                    count++;
                    break;
                }
            }
        }
        return n - count;
    }
}