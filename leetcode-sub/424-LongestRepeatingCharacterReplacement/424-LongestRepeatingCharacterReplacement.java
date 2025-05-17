// Last updated: 5/17/2025, 5:07:59 PM
class Solution {
    public int characterReplacement(String s, int k) {
        int max = Integer.MIN_VALUE, count = 0, left = 0, right = 0;
        int[] map = new int[26];
        char[] arr = s.toCharArray();
        int n = arr.length;
        while (right < n) {
            map[arr[right] - 'A']++;
            count = Math.max(count, map[arr[right] - 'A']);
            right++;
            while (right - left > k + count) {
                map[arr[left] - 'A']--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}