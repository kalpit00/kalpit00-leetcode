// Last updated: 8/9/2025, 12:38:48 AM
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        int[] map = new int[1000001];
        for (int i = 0; i < n; i++) {
            map[x[i]] = Math.max(map[x[i]], y[i]);
        }
        int[] max = helper(map);
        if (max[0] == -1 || max[1] == -1 || max[2] == -1) {
            return -1;
        }
        return max[0] + max[1] + max[2];
    }
    private int[] helper(int[] nums) {
        int max1 = -1, max2 = -1, max3 = -1;
        for (int num : nums) {
            if (num == 0) continue;
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }
        return new int[] {max1, max2, max3};
    }
}