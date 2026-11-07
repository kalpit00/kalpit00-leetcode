// Last updated: 11/6/2026, 8:59:32 PM
1class Solution {
2
3    public int[] assignTasks(int[] servers, int[] tasks) {
4        // Busy servers, stored as pairs (t, idx)
5        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);
6
7        // Idle servers, stored as pairs (w, idx)
8        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
9            if (a[0] != b[0]) {
10                return a[0] - b[0];
11            }
12            return a[1] - b[1];
13        });
14
15        for (int i = 0; i < servers.length; i++) {
16            idle.offer(new int[] { servers[i], i });
17        }
18
19        int ts = 0;
20        int[] ans = new int[tasks.length];
21
22        for (int i = 0; i < tasks.length; i++) {
23            ts = Math.max(ts, i);
24            release(busy, idle, servers, ts);
25            if (idle.isEmpty()) {
26                ts = busy.peek()[0];
27                release(busy, idle, servers, ts);
28            }
29
30            int[] server = idle.poll();
31            int idx = server[1];
32            ans[i] = idx;
33            busy.offer(new int[] { ts + tasks[i], idx });
34        }
35
36        return ans;
37    }
38
39    // Move servers with t<=ts from priority queue busy to priority queue idle one by one
40    private void release(
41        PriorityQueue<int[]> busy,
42        PriorityQueue<int[]> idle,
43        int[] servers,
44        int ts
45    ) {
46        while (!busy.isEmpty() && busy.peek()[0] <= ts) {
47            int[] server = busy.poll();
48            int idx = server[1];
49            idle.offer(new int[] { servers[idx], idx });
50        }
51    }
52}