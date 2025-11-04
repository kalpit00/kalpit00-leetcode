// Last updated: 11/3/2025, 11:26:28 PM
class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int[][] map = new int[51][2];
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                map[nums[j]][0]++;
                map[nums[j]][1] = nums[j];
            }
            Arrays.sort(map, (a, b) -> a[0] != b[0] ? 
            b[0] - a[0] : b[1] - a[1]);
            for (int s = 0; s < x; s++) {
                if (map[s][0] == 0) break;
                sum += map[s][0] * map[s][1];
            }
            res[i] = sum;
        }
        return res;
    }
}