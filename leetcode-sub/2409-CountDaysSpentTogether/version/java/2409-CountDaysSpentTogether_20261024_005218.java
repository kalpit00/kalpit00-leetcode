// Last updated: 10/24/2026, 12:52:18 AM
1class Solution {
2
3    public int countDaysTogether(
4        String arriveAlice,
5        String leaveAlice,
6        String arriveBob,
7        String leaveBob
8    ) {
9        int[] datesOfMonths = {
10            31,
11            28,
12            31,
13            30,
14            31,
15            30,
16            31,
17            31,
18            30,
19            31,
20            30,
21            31,
22        };
23        int[] prefixSum = new int[13];
24        for (int i = 0; i < 12; i++) {
25            prefixSum[i + 1] = prefixSum[i] + datesOfMonths[i];
26        }
27
28        int arriveAliceDay = calculateDayOfYear(arriveAlice, prefixSum);
29        int leaveAliceDay = calculateDayOfYear(leaveAlice, prefixSum);
30        int arriveBobDay = calculateDayOfYear(arriveBob, prefixSum);
31        int leaveBobDay = calculateDayOfYear(leaveBob, prefixSum);
32        return Math.max(
33            0,
34            Math.min(leaveAliceDay, leaveBobDay) -
35                Math.max(arriveAliceDay, arriveBobDay) +
36                1
37        );
38    }
39
40    private int calculateDayOfYear(String day, int[] prefixSum) {
41        int month = Integer.parseInt(day.substring(0, 2));
42        int date = Integer.parseInt(day.substring(3));
43        return prefixSum[month - 1] + date;
44    }
45}