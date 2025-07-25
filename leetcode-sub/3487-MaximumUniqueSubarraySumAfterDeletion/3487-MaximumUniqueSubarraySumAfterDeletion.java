// Last updated: 7/24/2025, 10:11:57 PM
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