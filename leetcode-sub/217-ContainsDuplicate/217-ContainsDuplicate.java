// Last updated: 8/27/2025, 3:25:15 AM
class Solution {
    public String breakPalindrome(String palindrome) {
        char[] arr = palindrome.toCharArray();
        int n = arr.length, idx = 0;
        if (n == 1) {
            return "";
        }
        boolean flag = false;
        char c = 'a';
        for (int i = 0; i < n; i++) {
            if (arr[i] != 'a') {
                idx = i;
                c = arr[i];
                arr[i] = 'a';
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            flag = arr[i] != 'a' ? true : flag;
        }
        if (!flag) {
            arr[idx] = c;
            arr[n - 1] = 'b';
        }
        return new String(arr);
    }
}