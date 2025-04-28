// Last updated: 4/28/2025, 5:15:36 PM
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 3) {
                map.remove(num);
            }
        }
        return map.keySet().iterator().next();
    }
}