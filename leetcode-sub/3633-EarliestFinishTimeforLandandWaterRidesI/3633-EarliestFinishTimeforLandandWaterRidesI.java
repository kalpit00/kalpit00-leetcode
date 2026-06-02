// Last updated: 6/1/2026, 10:24:41 PM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
3    int[] waterStartTime, int[] waterDuration) {
4        int land_water = solve(landStartTime, landDuration, waterStartTime,waterDuration);
5        int water_land = solve(waterStartTime, waterDuration, landStartTime, landDuration);
6        return Math.min(land_water, water_land);
7    }
8    private int solve(int[] start1, int[] duration1, int[] start2, 
9    int[] duration2) {
10        int finish1 = Integer.MAX_VALUE;
11        for (int i = 0; i < start1.length; i++) {
12            finish1 = Math.min(finish1, start1[i] + duration1[i]);
13        }
14        int finish2 = Integer.MAX_VALUE;
15        for (int i = 0; i < start2.length; i++) {
16            finish2 = Math.min(finish2, Math.max(start2[i], finish1) + 
17            duration2[i]);
18        }
19        return finish2;
20    }
21}