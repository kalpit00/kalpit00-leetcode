// Last updated: 7/11/2025, 6:24:53 PM
class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length, left = 0, right = 0, count = 0, k = logs.length;
        int[][] nums = new int[m][2];
        int[] res = new int[m], map = new int[100001];
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
                if (map[key] == 0) {
                    count++;
                }
                map[key]++;
                right++;
            }
            while (left < k && logs[left][1] < start) {
                int key = logs[left][0];
                if (map[key] == 1) {
                    count--;
                }
                map[key]--;
                left++;
            }
            res[idx] = n - count;
        }
        return res;
    }
}