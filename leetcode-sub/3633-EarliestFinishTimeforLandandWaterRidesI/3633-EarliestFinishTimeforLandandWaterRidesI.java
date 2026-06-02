// Last updated: 6/1/2026, 10:23:54 PM
1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3        int land_water = solve(landStartTime, landDuration, waterStartTime,waterDuration);
4        int water_land = solve(waterStartTime, waterDuration, landStartTime, landDuration);
5        return Math.min(land_water, water_land);
6    }
7    private int solve(int[] start1, int[] duration1, int[] start2, int[] duration2) {
8        int finish1 = Integer.MAX_VALUE;
9        for (int i = 0; i < start1.length; i++) {
10            finish1 = Math.min(finish1, start1[i] + duration1[i]);
11        }
12        int finish2 = Integer.MAX_VALUE;
13        for (int i = 0; i < start2.length; i++) {
14            finish2 = Math.min(
15                finish2,
16                Math.max(start2[i], finish1) + duration2[i]
17            );
18        }
19        return finish2;
20    }
21}