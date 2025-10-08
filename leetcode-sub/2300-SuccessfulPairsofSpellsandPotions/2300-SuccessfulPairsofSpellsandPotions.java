// Last updated: 10/7/2025, 8:00:27 PM
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        Arrays.sort(potions);
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int idx = binarySearch(potions, success, spells[i]);
            res[i] = (idx != -1) ? m - idx : 0;
        }
        return res;
    }
    private int binarySearch(int[] potions, long success, int strength) {
        int n = potions.length;
        int start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if ((long) potions[mid] * strength >= success) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}