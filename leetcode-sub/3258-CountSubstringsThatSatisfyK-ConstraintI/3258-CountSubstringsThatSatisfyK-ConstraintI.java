// Last updated: 10/4/2025, 6:16:38 AM
class Solution {
    public int reverseDegree(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, res = 0;
        for (int i = 1; i <= n; i++) {
            int x = arr[i - 1] - 'a';
            res += (26 - x) * i;
        }
        return res;
    }
}