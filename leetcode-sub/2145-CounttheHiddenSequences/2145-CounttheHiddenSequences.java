// Last updated: 4/20/2025, 11:04:40 PM
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, max = 0, min = 0;
        for (int num : differences) {
            sum += num;
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }
        int ans = (int) (upper - lower + 1 - (max - min));
        return ans > 0 ? ans : 0;
    }
}