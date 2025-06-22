// Last updated: 6/21/2025, 8:09:27 PM
class Solution {
    public String[] divideString(String s, int k, char fill) {
        while (s.length() % k != 0) {
            s += fill;
        }
        int n = s.length(), idx = 0;
        String[] res = new String[n / k];
        for (int i = 0; i < s.length(); i += k) {
            res[idx++] = s.substring(i, i + k);
        }
        return res;
    }
}