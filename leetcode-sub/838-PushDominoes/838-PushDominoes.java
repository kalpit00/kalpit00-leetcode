// Last updated: 5/1/2025, 9:10:40 PM
class Solution {
    public String pushDominoes(String s) {
        int n = s.length(), f = 0;
        char[] arr = s.toCharArray();
        int[] force = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') f = n;
            else if (arr[i] == 'L') f = 0;
            else f = Math.max(f - 1, 0);
            force[i] += f;
        }
        f = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') f = n;
            else if (arr[i] == 'R') f = 0;
            else f = Math.max(f - 1, 0);
            force[i] -= f;
        }
        for (int i = 0; i < n; i++) {
            if (force[i] > 0) arr[i] = 'R';
            else if (force[i] < 0) arr[i] = 'L';
            else arr[i] = '.';
        }
        return new String(arr);
    }
}
