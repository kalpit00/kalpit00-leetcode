// Last updated: 4/30/2025, 1:15:06 AM
class Solution {
    public String replaceDigits(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 1; i < n; i += 2) {
            arr[i] += arr[i - 1] - '0';
        }
        return new String(arr);
    }
}