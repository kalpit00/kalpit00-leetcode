// Last updated: 5/27/2025, 4:58:51 AM
class Solution {
    public int maxSum(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        boolean[] visited = new boolean[202];
        for (int num : nums) {
            sum += num > 0 && !visited[num + 100] ? num : 0;
            visited[num + 100] = true;
            max = Math.max(max, num);
        }
        return max < 0 ? max : sum;
    }
}