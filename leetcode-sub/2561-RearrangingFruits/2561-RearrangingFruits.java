// Last updated: 8/2/2025, 5:14:29 AM
class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new TreeMap<>();
        int min = Integer.MAX_VALUE;
        for (int num : basket1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            min = Math.min(min, num);
        }
        for (int num : basket2) {
            map.put(num, map.getOrDefault(num, 0) - 1);
            min = Math.min(min, num);
        }
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 != 0) {
                return -1;
            }
            for (int i = 0; i < Math.abs(count) / 2; i++) {
                list.add(key);
            }
        }
        Collections.sort(list);
        long res = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            res += Math.min(2 * min, list.get(i));
        }
        return res;
    }
}