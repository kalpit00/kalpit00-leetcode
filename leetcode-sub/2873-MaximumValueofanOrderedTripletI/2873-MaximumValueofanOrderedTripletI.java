// Last updated: 4/2/2025, 5:14:17 AM
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] visited = new boolean[301];
        int count = 0;
        for (int num : nums) {
            int shift = num + 100;
            count += visited[shift - diff] && visited[shift - 2 * diff] ? 1 : 0;
            visited[shift] = true;
        }
        return count;
    }
}