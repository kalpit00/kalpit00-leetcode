// Last updated: 8/15/2025, 3:44:53 AM
class Solution {
    public String getSmallestString(int n, int k) {
        char[] res = new char[n];
        for (int i = n - 1; i >= 0; i--) {
            if (k - i >= 26) {
                res[i] = 'z';
                k -= 26;
            }
            else {
                res[i] = (char) ((k - i - 1) + 'a');
                k = i; // k - (k - i)
            }
        }
        return new String(res);
    }
}