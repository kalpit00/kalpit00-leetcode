// Last updated: 9/12/2025, 12:21:10 AM
class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0], sum = 0;
        for (int i = 1; i < numsDivide.length; i++) {
            gcd = gcd(gcd, numsDivide[i]);
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {        
            if (gcd % key == 0) {
                return sum;
            }
            sum += map.get(key);
        }
        return sum != 0 ? -1 : sum;
    }
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}