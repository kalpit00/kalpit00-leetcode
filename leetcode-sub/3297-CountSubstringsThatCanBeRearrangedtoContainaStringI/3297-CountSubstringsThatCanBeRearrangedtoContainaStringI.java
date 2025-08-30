// Last updated: 8/30/2025, 1:07:45 AM
class Solution {
    public long validSubstringCount(String word1, String word2) {
        int[] map = new int[26], pre = new int[26];
        char[] nums = word1.toCharArray(), arr = word2.toCharArray();
        for (char c : arr) {
            map[c - 'a']++;
        }
        int left = 0, right = 0, n = nums.length, m = arr.length;
        long count = 0;
        while (right < n) {
            pre[nums[right] - 'a']++;
            while (left <= right && helper(pre, map)) {
                count += n - right;
                pre[nums[left] - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }
    private boolean helper(int[] pre, int[] map) {
        for (int i = 0; i < 26; i++) {
            if (pre[i] < map[i]) {
                return false;
            }
        }
        return true;
    }
}