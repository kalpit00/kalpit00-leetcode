// Last updated: 8/14/2025, 1:42:24 PM
class Solution {
    public int removeAlmostEqualCharacters(String word) {
        char[] arr = word.toCharArray();
        int n = arr.length, count = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1] || Math.abs(arr[i] - arr[i - 1]) == 1) {
                i++;
                count++;
            }
        }
        return count;
    }

}