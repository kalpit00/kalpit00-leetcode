// Last updated: 11/22/2025, 6:29:55 AM
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] pos = new int[101];
        for (int i = 0; i < arr.length; i++) pos[arr[i]] = i + 1;

        for (int[] p : pieces) {
            int start = pos[p[0]];
            if (start == 0) return false;
            int idx = start - 1;

            for (int i = 0; i < p.length; i++) {
                if (idx + i >= arr.length || arr[idx + i] != p[i]) return false;
            }
        }
        return true;
    }
}
