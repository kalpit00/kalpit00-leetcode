// Last updated: 12/26/2025, 11:24:34 PM
1class Solution {
2    public int mostBooked(int n, int[][] meetings) {
3        var meetingCount = new int[n];
4        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
5        var unusedRooms = new PriorityQueue<Integer>();
6
7        for (int i = 0; i < n; i++) {
8            unusedRooms.offer(i);
9        }
10
11        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
12
13        for (int[] meeting : meetings) {
14            int start = meeting[0], end = meeting[1];
15
16            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
17                int room = (int) usedRooms.poll()[1];
18                unusedRooms.offer(room);
19            }
20
21            if (!unusedRooms.isEmpty()) {
22                int room = unusedRooms.poll();
23                usedRooms.offer(new long[]{end, room});
24                meetingCount[room]++;
25            } else {
26                long roomAvailabilityTime = usedRooms.peek()[0];
27                int room = (int) usedRooms.poll()[1];
28                usedRooms.offer(new long[]{roomAvailabilityTime + end - start, room});
29                meetingCount[room]++;
30            }
31        }
32
33        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
34        for (int i = 0; i < n; i++) {
35            if (meetingCount[i] > maxMeetingCount) {
36                maxMeetingCount = meetingCount[i];
37                maxMeetingCountRoom = i;
38            }
39        }
40
41        return maxMeetingCountRoom;
42    }
43}