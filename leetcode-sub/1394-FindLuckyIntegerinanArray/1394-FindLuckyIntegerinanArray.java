// Last updated: 7/5/2025, 12:09:56 AM
class Solution {
    public int findLucky(int[] arr) {
        int[] map = new int[501];
        for (int num : arr) {
            map[num]++;
        }
        for (int i = 500; i >= 1; i--) {
            if (map[i] == i) {
                return i;
            }
        }
        return -1;
    }
}