// Last updated: 4/1/2025, 4:05:42 PM
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1];
        int[] res = new int[2];
        for (int num : nums) {
            if (visited[num]) {
                res[0] = num;
            }
            visited[num] = true;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                res[1] = i;
            }
        }
        return res;
    }
}