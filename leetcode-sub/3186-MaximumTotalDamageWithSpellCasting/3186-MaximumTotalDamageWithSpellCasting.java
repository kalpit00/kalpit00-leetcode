// Last updated: 10/10/2025, 8:04:41 PM
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> map = new HashMap<>();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0l) + 1);
        } // store freqCount of each element
        int n = map.size(), idx = 0;
        int[] nums = new int[n];
        for (int key : map.keySet()) {
            nums[idx++] = key;
        }
        Arrays.sort(nums);
        Long[] dp = new Long[n];
        return solve(0, n, nums, map, dp);
    }
    private long solve(int i, int n, int[] nums, Map<Integer, Long> map,
    Long[] dp) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != null) {
            return dp[i];
        }
        long notTake = solve(i + 1, n, nums, map, dp);
        int j = i;
        while (j < n && nums[j] <= nums[i] + 2) {
            j++; // skip nums[j] + 1 and nums[j] + 2
        } // take all occurrences of nums[i] -> mulitply by its freq
        long take = nums[i] * map.get(nums[i]) + solve(j, n, nums, map, dp);
        return dp[i] = Math.max(notTake, take);
    }
}