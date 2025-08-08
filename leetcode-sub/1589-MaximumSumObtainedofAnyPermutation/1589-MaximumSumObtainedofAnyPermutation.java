// Last updated: 8/8/2025, 5:54:02 PM
class Solution {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        int m = requests.length, n = nums.length, mod = 1000000007;
        long sum = 0;
        int[] count = new int[n];
        for (int[] request : requests) {
            int start = request[0], end = request[1], val = 1;
            count[start] += val;
            if (end + 1 < n) {
                count[end + 1] -= val;
            }
        }
        for (int i = 1 ; i < n; i++) {
            count[i] += count[i - 1];
        }
        Arrays.sort(nums);
        Arrays.sort(count);
        for (int i = 0; i < n; i++) {
            sum += 1L * nums[i] * count[i];
        }
        return (int) (sum % mod);
    }
}