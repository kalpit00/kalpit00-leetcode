// Last updated: 12/22/2025, 7:18:11 PM
1class Solution {
2
3    public int maxTwoEvents(int[][] events) {
4        List<int[]> times = new ArrayList<>();
5
6        // Convert events into start and end times with their values
7        for (int[] event : events) {
8            // 1 denotes start time
9            times.add(new int[] { event[0], 1, event[2] });
10            // 0 denotes end time
11            times.add(new int[] { event[1] + 1, 0, event[2] });
12        }
13
14        // Sort the times: first by time, then by type (end before start for same time)
15        times.sort((a, b) ->
16            a[0] == b[0]
17                ? Integer.compare(a[1], b[1])
18                : Integer.compare(a[0], b[0])
19        );
20
21        int ans = 0, maxValue = 0;
22
23        // Process the sorted times
24        for (int[] timeValue : times) {
25            if (timeValue[1] == 1) {
26                // Start time: Calculate the maximum sum
27                ans = Math.max(ans, timeValue[2] + maxValue);
28            } else {
29                // End time: Update the maximum value seen so far
30                maxValue = Math.max(maxValue, timeValue[2]);
31            }
32        }
33
34        return ans;
35    }
36}