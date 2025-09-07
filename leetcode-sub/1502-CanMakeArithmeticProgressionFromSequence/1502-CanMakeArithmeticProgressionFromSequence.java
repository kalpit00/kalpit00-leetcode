// Last updated: 9/7/2025, 4:51:56 PM
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int x = 0, y = 0, z = 0;
        for (char c : firstWord.toCharArray()) {
            x = x * 10 + (c - 'a');
        }
        for (char c : secondWord.toCharArray()) {
            y = y * 10 + (c - 'a');
        }
        for (char c : targetWord.toCharArray()) {
            z = z * 10 + (c - 'a');
        }
        return x + y == z;
    }
}