// Last updated: 10/9/2025, 8:04:41 PM
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, max = Integer.MIN_VALUE;
        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}