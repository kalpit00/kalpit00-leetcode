// Last updated: 7/16/2026, 8:45:34 PM
1class Solution {
2
3    public int[] gcdValues(int[] nums, long[] queries) {
4        int m = 0;
5        for (int num : nums) {
6            m = Math.max(m, num);
7        }
8        long[] cnt = new long[m + 1];
9        for (int num : nums) {
10            cnt[num]++;
11        }
12        for (int i = 1; i <= m; i++) {
13            for (int j = i * 2; j <= m; j += i) {
14                cnt[i] += cnt[j];
15            }
16        }
17        for (int i = 1; i <= m; i++) {
18            cnt[i] = (cnt[i] * (cnt[i] - 1)) / 2;
19        }
20        for (int i = m; i >= 1; i--) {
21            for (int j = i * 2; j <= m; j += i) {
22                cnt[i] -= cnt[j];
23            }
24        }
25        for (int i = 1; i <= m; i++) {
26            cnt[i] += cnt[i - 1];
27        }
28        int[] ans = new int[queries.length];
29        for (int k = 0; k < queries.length; k++) {
30            long q = queries[k] + 1;
31            int left = 1,
32                right = m;
33            while (left < right) {
34                int mid = (left + right) / 2;
35                if (cnt[mid] >= q) {
36                    right = mid;
37                } else {
38                    left = mid + 1;
39                }
40            }
41            ans[k] = left;
42        }
43        return ans;
44    }
45}