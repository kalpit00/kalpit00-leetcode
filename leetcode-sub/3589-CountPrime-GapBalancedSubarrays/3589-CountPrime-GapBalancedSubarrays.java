// Last updated: 8/27/2025, 7:47:16 PM
class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length, left = 0, right = 0, max = 0, res = 0, count = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] notPrime = sieve(max + 1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (!notPrime[nums[i]]) {
                count++;
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            while (count > 1) {
                if (!notPrime[nums[right]]) {
                    count--;
                }
                right++;
            }
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > k) {
                if (!notPrime[nums[left]]) {
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }
    public boolean[] sieve(int n) {
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return notPrime;
    }
}