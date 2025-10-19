// Last updated: 10/19/2025, 5:15:21 AM
class Solution {
    public int numSub(String s) {
        char[] arr = s.toCharArray();
        long count = 0;
        int n = arr.length, mod = 1000000007;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                continue;
            }
            int m = 1; // m = streak length
            while (i < n - 1 && arr[i] == '1' && arr[i + 1] == '1') {
                i++;
                m++;
            }
            count += 1L * m * (m + 1) / 2;
            count %= mod;
        }
        return (int) count;
    }
}