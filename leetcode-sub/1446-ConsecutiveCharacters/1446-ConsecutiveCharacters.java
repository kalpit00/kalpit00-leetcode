// Last updated: 11/15/2025, 11:42:15 PM
class Solution {
    public int maxPower(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length, max = 0;
        for (int i = 0; i < n; i++) {
            int m = 1; // m = streak length
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
                m++;
            }
            max = Math.max(max, m);
        }
        return max;
    }
}