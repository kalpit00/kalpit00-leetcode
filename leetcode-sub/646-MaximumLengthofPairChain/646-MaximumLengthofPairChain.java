// Last updated: 11/22/2025, 6:25:12 AM
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int n = arr.length, i = 0;
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        } // use 1st item in each piece as key. store entire piece as value
        while (i < n) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] piece = map.get(arr[i]);
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