// Last updated: 7/21/2025, 9:26:16 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[] map = new int[128];
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int counter = 0;
        while (right < s.length()) {
            if (map[s.charAt(right)] > 0) {
                counter++;
            }
            map[s.charAt(right)]++;
            right++;
            while (counter > 0) {
                if (map[s.charAt(left)] > 1) {
                    counter--;
                }
                map[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}