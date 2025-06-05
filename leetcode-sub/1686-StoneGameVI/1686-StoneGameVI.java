// Last updated: 6/5/2025, 1:17:41 AM
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length, aliceSum = 0, bobSum = 0;
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            map[i][0] = aliceValues[i] + bobValues[i];
            map[i][1] = aliceValues[i];
            map[i][2] = bobValues[i];
        }
        Arrays.sort(map, (a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                aliceSum += map[i][1];
            } 
            else {
                bobSum += map[i][2];
            }
        }
        return aliceSum > bobSum ? 1 : aliceSum == bobSum ? 0 : -1;
    }
}