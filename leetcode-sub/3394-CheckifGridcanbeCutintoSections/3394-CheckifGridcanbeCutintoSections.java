// Last updated: 3/25/2025, 6:43:24 AM
class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        return check(rectangles, 0) || check(rectangles, 1);
    }

    private boolean check(int[][] rectangles, int i) {
        int res = 0;
        Arrays.sort(rectangles, (a, b) -> Integer.compare(a[i], b[i]));
        int pre = rectangles[0][i + 2];
        for (int[] r : rectangles) {
            if (pre <= r[i]) {
                res++;
            }
            pre = Math.max(pre, r[i + 2]);
        }
        return res > 1;
    }
}