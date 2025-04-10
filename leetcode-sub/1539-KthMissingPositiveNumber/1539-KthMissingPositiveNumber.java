// Last updated: 4/9/2025, 9:34:30 PM
class Solution {
    public int findKthPositive(int[] arr, int k) {
        boolean[] visited = new boolean[2002];
        for (int num : arr) {
            visited[num] = true;
        }
        int i = 1;
        while (k > 0) {
            if (!visited[i]) {
                k--;
            }
            i++;
        }
        return i - 1;
    }
}
