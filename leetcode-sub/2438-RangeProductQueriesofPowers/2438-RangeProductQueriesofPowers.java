// Last updated: 8/10/2025, 9:28:22 PM
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
        for (int i = 0; i < m; i++) {
            int l = queries[i][0], r = queries[i][1];
            long prod = 1;
            for (int j = l; j <= r; j++) {
                prod *= nums[j];
                prod %= mod;
            }
            res[i] = (int) prod;
        }
        return res;
    }
}
