// Last updated: 8/27/2025, 7:45:45 PM
class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n = nums.length, left1 = 0, left2 = 0, right = 0, 
        max = 0, res = 0, count = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] notPrime = sieve(max + 1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        while (right < n) {
            if (!notPrime[nums[right]]) {
                count++;
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            }
            while (count > 1) {
                if (!notPrime[nums[left1]]) {
                    count--;
                }
                left1++;
            }
            while (!map.isEmpty() && map.lastKey() - map.firstKey() > k) {
                if (!notPrime[nums[left2]]) {
                    map.put(nums[left2], map.get(nums[left2]) - 1);
                    if (map.get(nums[left2]) == 0) {
                        map.remove(nums[left2]);
                    }
                }
                left2++;
            }
            res += left1 - left2; // res += (r - l2 + 1) - (r - l1 + 1)
            right++;
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