// Last updated: 7/11/2025, 11:35:23 PM
class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int p1 = Math.min(firstPlayer, secondPlayer);
        int p2 = Math.max(firstPlayer, secondPlayer);
        if (p1 + p2 == n + 1) {
            // p1 and p2 compete in the first round
            return new int[]{1, 1};
        }
        if (n == 3 || n == 4) {
            // p1 and p2 must compete in the second round (only two rounds).
            return new int[]{2, 2};
        }

        // Flip to make p1 be more closer to left than p2 to right end for convenience
        if (p1 - 1 > n - p2) {
            int t = n + 1 - p1;
            p1 = n + 1 - p2;
            p2 = t;
        }

        int m = (n + 1) / 2;
        int min = n;
        int max = 1;
        if (p2 * 2 <= n + 1) {
            // p2 is in the first half (n odd or even) or exact middle (n odd)
            int a = p1 - 1;
            int b = p2 - p1 - 1;
            // i represents the number of front players in A wins
            // j represents the number of front players in B wins
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 2);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        } else {
            // p2 is in the later half (and has >= p1 distance to the end)
            int p4 = n + 1 - p2;
            int a = p1 - 1;
            int b = p4 - p1 - 1;
            // Group C are players between p4 and p2, (c+1)/2 will advance to the next round.
            int c = p2 - p4 - 1;
            for (int i = 0; i <= a; i++) {
                for (int j = 0; j <= b; j++) {
                    int[] ret = earliestAndLatest(m, i + 1, i + j + 1 + (c + 1) / 2 + 1);
                    min = Math.min(min, 1 + ret[0]);
                    max = Math.max(max, 1 + ret[1]);
                }
            }
        }
        return new int[]{min, max};
    }
}