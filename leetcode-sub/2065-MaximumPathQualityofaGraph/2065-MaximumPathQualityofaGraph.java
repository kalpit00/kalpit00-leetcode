// Last updated: 7/11/2025, 6:22:59 PM
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length, left = 0, right = 0, k = logs.length;
        int[][] nums = new int[m][2];
        int[] res = new int[m];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            nums[i][0] = queries[i] - x;
            nums[i][1] = i;
        }
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        for (int[] query : nums) {
            int start = query[0], end = start + x, idx = query[1];
            while (right < k && logs[right][1] <= end) {
                int key = logs[right][0];
                map.put(key, map.getOrDefault(key, 0) + 1);
                right++;
            }
            while (left < k && logs[left][1] < start) {
                int key = logs[left][0];
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                left++;
            }
            res[idx] = n - map.size();
        }
        return res;
    }
}