// Last updated: 9/12/2025, 8:42:41 PM
class Solution {
    public int maxFreqSum(String s) {
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int max1 = 0, max2 = 0;
        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                max1 = Math.max(max1, map[i]);
            }
            else {
                max2 = Math.max(max2, map[i]);
            }
        }
        return max1 + max2;
    }
}