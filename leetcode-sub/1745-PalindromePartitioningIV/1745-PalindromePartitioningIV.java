// Last updated: 5/13/2025, 9:17:53 PM
class Solution {
    public boolean checkPartitioning(String s) {
        int n = s.length();
        int[] p = manacher(convert(s));        
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPalindrome(0, i - 1, p) &&
                    isPalindrome(i, j - 1, p) &&
                    isPalindrome(j, n - 1, p)) {
                    return true;
                }
            }
        }
        return false;
    }
    private char[] convert(String s) {
        int n = s.length() * 2 + 3;
        char[] arr = new char[n];
        int idx = 0;
        arr[idx++] = '@';
        arr[idx++] = '#';
        for (char c : s.toCharArray()) {
            arr[idx++] = c;
            arr[idx++] = '#';
        }
        arr[n - 1] = '$';
        return arr;
    }

    private int[] manacher(char[] arr) {
        int n = arr.length;
        int[] p = new int[n];
        int center = 0, maxRight = 0;
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < maxRight) {
                p[i] = Math.min(maxRight - i, p[mirror]);
            }
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n &&
                   arr[i - p[i] - 1] == arr[i + p[i] + 1]) {
                p[i]++;
            }
            if (i + p[i] > maxRight) {
                center = i;
                maxRight = i + p[i];
            }
        }
        return p;
    }

    private boolean isPalindrome(int i, int j, int[] p) {
        int left = 2 * i + 2, right = 2 * j + 2;
        int center = (left + right) / 2;
        return p[center] >= (right - left) / 2;
    }
}
