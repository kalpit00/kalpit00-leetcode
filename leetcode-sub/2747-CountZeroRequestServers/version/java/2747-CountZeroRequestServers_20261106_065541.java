// Last updated: 11/6/2026, 6:55:41 AM
1class Solution {
2    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
3        int m = queries.length, left = 0, right = 0, count = 0, k = logs.length;
4        int[][] nums = new int[m][2];
5        int[] res = new int[m], map = new int[100001];
6        for (int i = 0; i < m; i++) {
7            nums[i][0] = queries[i] - x;
8            nums[i][1] = i;
9        }
10        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
11        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
12        for (int[] query : nums) {
13            int start = query[0], end = start + x, idx = query[1];
14            while (right < k && logs[right][1] <= end) {
15                count += (map[logs[right][0]] == 0) ? 1 : 0;
16                map[logs[right][0]]++;
17                right++;
18            }
19            while (left < k && logs[left][1] < start) {
20                map[logs[left][0]]--;
21                count -= (map[logs[left][0]] == 0) ? 1 : 0;
22                left++;
23            }
24            res[idx] = n - count;
25        }
26        return res;
27    }
28}