// Last updated: 4/4/2025, 10:47:25 PM
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double start = 0, end = 1;
        while (start <= end) {
            double mid = start + (end - start) / 2;
            int[] res = helper(arr, mid, k);
            int count = res[0];
            if (count == k) {
                return new int[] {res[1], res[2]};
            }
            else if (count > k) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return new int[]{};
    }

    public int[] helper(int[] arr, double mid, int k) {
        int n = arr.length, j = 1, count = 0;
        double max = 0.0;
        int[] res = new int[3];
        for (int i = 0; i < n - 1; i++) {
            while (j < n && arr[i] >= mid * arr[j]) {
                j++;
            }
            count += n - j;
            if (j == n) {
                break;
            }
            double fraction = (double) arr[i] / arr[j];
            if (fraction > max) {
                max = fraction;
                res[1] = arr[i];
                res[2] = arr[j];
            }
        }
        res[0] = count;
        return res;
    }
}