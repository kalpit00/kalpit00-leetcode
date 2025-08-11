// Last updated: 8/10/2025, 8:59:23 PM
class Solution {
    int mod = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        char[] arr = Integer.toBinaryString(n).toCharArray();
        int m = queries.length, k = 0, idx = 0, t = arr.length;
        for (char c : arr) {
            k += c == '1' ? 1 : 0;
        }
        int[] res = new int[m], nums = new int[k];
        for (int i = t - 1; i >= 0; i--) {
            if (arr[i] == '1') {
                nums[idx++] = 1 << (t - i - 1);
            }
        }
        long[] pre = new long[k + 1];
        pre[0] = 1;
        for (int i = 1; i <= k; i++) {
            pre[i] = (pre[i - 1] * nums[i - 1]) % mod;
        }
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            res[i] = (int) ((pre[r + 1] * modPow(pre[l], mod - 2)) % mod);
        } // (a / b) % mod == (a * b^(mod - 2)) % mod -> Fermats Little theorem
        return res;
    }
    private long modPow(long base, long exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp % 2) == 1) {
                res = (res * base) % mod;
            } // a^b with mods for large numbers
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
}
