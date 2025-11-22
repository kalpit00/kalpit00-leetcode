// Last updated: 11/22/2025, 6:38:54 AM
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[][] map = new int[101][];
        int n = arr.length, i = 0;
        for (int[] piece : pieces) {
            map[piece[0]] = piece;
        } // use 1st item in each piece as key. store entire piece as value
        while (i < n) {
            if (map[arr[i]] == null) {
                return false;
            }
            int[] piece = map[arr[i]];
            for (int j = 0; j < piece.length; j++) {
                if (arr[i] != piece[j]) {
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}