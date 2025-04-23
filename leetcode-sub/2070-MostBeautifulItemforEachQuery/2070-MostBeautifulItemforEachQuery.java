// Last updated: 4/23/2025, 2:47:18 PM
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        int n = items.length, m = queries.length;
        int[][] pre = new int[n][2], sortedQueries = new int[m][2];
        int[] res = new int[m];
        pre[0] = items[0];
        for (int i = 1; i < n; i++) {
            pre[i][0] = items[i][0];
            pre[i][1] = Math.max(pre[i - 1][1], items[i][1]);
        }
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < m; i++) {
            int query = sortedQueries[i][0];
            int idx = binarySearchFloor(pre, query);
            res[sortedQueries[i][1]] = idx == -1 ? 0 : pre[idx][1];
        }
        return res;
    }

    private int binarySearchFloor(int[][] pre, int target) {
        int n = pre.length, start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (pre[mid][0] <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
