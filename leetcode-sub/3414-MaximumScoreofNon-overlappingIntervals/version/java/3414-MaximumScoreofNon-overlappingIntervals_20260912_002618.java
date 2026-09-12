// Last updated: 9/12/2026, 12:26:18 AM
1class Solution {
2
3    public int[] maximumWeight(List<List<Integer>> intervals) {
4        int n = intervals.size();
5        int[][] arr = new int[n][4];
6        for (int i = 0; i < n; i++) {
7            arr[i][0] = intervals.get(i).get(0);
8            arr[i][1] = intervals.get(i).get(1);
9            arr[i][2] = intervals.get(i).get(2);
10            arr[i][3] = i;
11        }
12        // Sort by right endpoint.
13        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
14
15        long[][] dp = new long[n + 1][5];
16        List<Integer>[][] indices = new List[n + 1][5];
17        for (int i = 0; i <= n; i++) {
18            for (int j = 0; j < 5; j++) {
19                indices[i][j] = new ArrayList<>();
20            }
21        }
22
23        for (int i = 0; i < n; i++) {
24            int l = arr[i][0],
25                weight = arr[i][2],
26                idx = arr[i][3];
27            // Use binary search to find intervals whose right endpoints are smaller than l.
28            int k = binarySearch(arr, i, l);
29
30            for (int j = 1; j < 5; j++) {
31                long s1 = dp[i][j];
32                long s2 = dp[k][j - 1] + weight;
33                if (s1 > s2) {
34                    dp[i + 1][j] = dp[i][j];
35                    indices[i + 1][j] = new ArrayList<>(indices[i][j]);
36                    continue;
37                }
38
39                List<Integer> newIndex = new ArrayList<>(indices[k][j - 1]);
40                newIndex.add(idx);
41                Collections.sort(newIndex);
42                if (s1 == s2 && compareLists(indices[i][j], newIndex) < 0) {
43                    newIndex = new ArrayList<>(indices[i][j]);
44                }
45                dp[i + 1][j] = s2;
46                indices[i + 1][j] = newIndex;
47            }
48        }
49
50        List<Integer> result = indices[n][4];
51        int[] ans = new int[result.size()];
52        for (int i = 0; i < result.size(); i++) {
53            ans[i] = result.get(i);
54        }
55        return ans;
56    }
57
58    private int binarySearch(int[][] arr, int end, int target) {
59        int left = 0,
60            right = end;
61        while (left < right) {
62            int mid = (left + right) / 2;
63            if (arr[mid][1] < target) {
64                left = mid + 1;
65            } else {
66                right = mid;
67            }
68        }
69        return left;
70    }
71
72    private int compareLists(List<Integer> a, List<Integer> b) {
73        int minLen = Math.min(a.size(), b.size());
74        for (int i = 0; i < minLen; i++) {
75            if (!a.get(i).equals(b.get(i))) {
76                return Integer.compare(a.get(i), b.get(i));
77            }
78        }
79        return Integer.compare(a.size(), b.size());
80    }
81}