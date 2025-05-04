// Last updated: 5/3/2025, 8:10:34 PM
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        int count = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1]
                ? domino[0] * 10 + domino[1]
                : domino[1] * 10 + domino[0];
            count += map[val];
            map[val]++;
        }
        return count;
    }
}