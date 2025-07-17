// Last updated: 7/16/2025, 11:06:26 PM
class Solution {
    public int destroyTargets(int[] nums, int space) {
        int min = Integer.MAX_VALUE, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num % space, map.getOrDefault(num % space, 0) + 1);
            max = Math.max(max, map.get(num % space));
        }
        for (int num : nums) {
            if (map.get(num % space) == max) {
                min = Math.min(min, num);
            }
        }
        return min;
    }
}