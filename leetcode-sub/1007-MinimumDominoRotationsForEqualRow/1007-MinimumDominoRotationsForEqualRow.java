// Last updated: 5/2/2025, 8:20:09 PM
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] map1 = new int[7], map2 = new int[7], map3 = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            map1[tops[i]]++;
            map2[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                map3[tops[i]]++;
            }
        }
        for (int i = 1; i <= 6; i++) {
            if (map1[i] + map2[i] - map3[i] == n) {
                return n - Math.max(map1[i], map2[i]);
            }
        }
        return -1;
    }
}