// Last updated: 6/23/2025, 2:09:03 AM
import java.math.BigInteger;

class Solution {
    public long kMirror(int k, int n) {
        int left = 1, count = 0;
        long sum = 0;
        while (count < n) {
            int right = left * 10;
            for (int j = 0; j < 2; j++) {
                for (int i = left; i < right && count < n; i++) {
                    long num = i;
                    int x = j == 0 ? i / 10 : i;
                    while (x > 0) {
                        num = num * 10 + (x % 10);
                        x /= 10;
                    }
                    if (isPalindrome(num, k)) {
                        count++;
                        sum += num;
                    }
                }
            }
            left = right;
        }
        return sum;
    }
    private boolean isPalindrome(long num, int k) {
        String s = new BigInteger(String.valueOf(num)).toString(k);
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i++] != arr[j--]) {
                return false;
            }
        }
        return true;
    }
}