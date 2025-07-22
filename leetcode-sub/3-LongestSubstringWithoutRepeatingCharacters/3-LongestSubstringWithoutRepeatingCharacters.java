// Last updated: 7/21/2025, 9:28:04 PM
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        char[] arr = s.toCharArray();
        int n = arr.length, max = 0, left = 0, right = 0, counter = 0;
        while (right < n) {
            if (map[arr[right]] > 0) {
                counter++;
            }
            map[arr[right]]++;
            right++;
            while (counter > 0) {
                if (map[arr[left]] > 1) {
                    counter--;
                }
                map[arr[left]]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}