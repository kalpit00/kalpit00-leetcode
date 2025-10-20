// Last updated: 10/20/2025, 5:47:59 AM
class Solution {
    public int countVowelSubstrings(String word) {
        char[] arr = word.toCharArray();
        return atMostKUnique(arr, 5) - atMostKUnique(arr, 4);
    }
    public int atMostKUnique(char[] arr, int k) {
        int count = 0, left = 0, right = 0, counter = 0, n = arr.length;
        int[] map = new int[26];
        while (right < n) {
            if (!isVowel(arr[right])) {
                left = right + 1;
                map = new int[26];
                counter = 0;
                right++;
                continue;
            }
            counter += map[arr[right] - 'a'] == 0 ? 1 : 0;
            map[arr[right] - 'a']++;
            right++;
            while (left < n && counter > k) {
                counter -= map[arr[left] - 'a'] == 1 ? 1 : 0;
                map[arr[left] - 'a']--;
                left++;
            }
            count += right - left;
        }
        return count;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}