// Last updated: 10/31/2025, 12:48:37 AM
class Solution {
    public int helper(int ind, int altSum, int product, int cnt, int[] nums, int k, int limit, Map<Long, Integer> mp) {
        if (ind == nums.length) {
            if (altSum == k && product <= limit) {
                return cnt == 0 ? Integer.MIN_VALUE : product;
            }
            return Integer.MIN_VALUE;
        }

        // Cap product to reduce state space
        if (product > limit) product = limit + 1;

        long key = ((long)ind * 2000L * 450 * 3) + ((altSum + 900L) * 450 * 3) + (product * 3L) + cnt;

        if (mp.containsKey(key)) return mp.get(key);

        int pick = Integer.MIN_VALUE;
        int val = nums[ind];

        if (cnt <= 1) {
            int newProduct = product * val;
            pick = Math.max(pick, helper(ind + 1, altSum + val, newProduct, 2, nums, k, limit, mp));
        } else if (cnt == 2) {
            int newProduct = product * val;
            pick = Math.max(pick, helper(ind + 1, altSum - val, newProduct, 1, nums, k, limit, mp));
        }

        int notPick = helper(ind + 1, altSum, product, cnt, nums, k, limit, mp);

        int res = Math.max(pick, notPick);
        mp.put(key, res);
        return res;
    }

    public int maxProduct(int[] nums, int k, int limit) {
        Map<Long, Integer> mp = new HashMap<>();
        int val = helper(0, 0, 1, 0, nums, k, limit, mp);
        return val == Integer.MIN_VALUE ? -1 : val;
    }
}