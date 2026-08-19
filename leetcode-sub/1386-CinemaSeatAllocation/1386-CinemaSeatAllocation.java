// Last updated: 8/18/2026, 9:17:42 PM
1class Solution {
2    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
3        int m = reservedSeats.length;
4        HashMap<Integer, boolean[]> map = new HashMap<>();
5        for (int i = 0; i < m; i++) {
6            int row = reservedSeats[i][0], seat = reservedSeats[i][1];
7            map.putIfAbsent(row, new boolean[10]);
8            map.get(row)[seat - 1] = true;
9        }
10        int count = 2 * (n - map.size());
11        for (boolean[] seats : map.values()) {
12            int groups = 0;
13            groups += !(seats[1] || seats[2] || seats[3] || seats[4]) ? 1 : 0;
14            groups += !(seats[5] || seats[6] || seats[7] || seats[8]) ? 1 : 0;
15            groups += groups == 0 && !(seats[3] || seats[4] || seats[5] || seats[6]) ? 1 : 0;
16            count += groups;
17        }
18        return count;
19    }
20}