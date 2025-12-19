// Last updated: 12/19/2025, 3:55:53 AM
1class Solution {
2    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
3        int n = profit.length;
4        int[][] activities = new int[n][3];
5        for (int i = 0; i < n; ++i) {
6            activities[i][0] = startTime[i];
7            activities[i][1] = endTime[i];
8            activities[i][2] = profit[i];
9            
10        }
11        // Arrays.sort(activities, (a, b) -> a[1] - b[1]);
12        Arrays.sort(activities, (a, b) -> Integer.compare(a[1], b[1]));
13        int[] dp = new int[n + 1];
14        for (int i = 0; i < n; ++i) {
15            int end = upperBound(activities, i, activities[i][0]);
16            dp[i + 1] = Math.max(dp[i], dp[end] + activities[i][2]);
17        }
18        return dp[n];
19    }
20    private int upperBound(int[][] activities, int end, int target) {
21        int start = 0, ans = -1;
22        while (start <= end) {
23            int mid = start + (end - start) / 2;
24            if (activities[mid][1] <= target) {
25                start = mid + 1;
26            } 
27            else {
28                end = mid - 1;
29                ans = mid;
30            }
31        }
32        return ans;
33    }
34}