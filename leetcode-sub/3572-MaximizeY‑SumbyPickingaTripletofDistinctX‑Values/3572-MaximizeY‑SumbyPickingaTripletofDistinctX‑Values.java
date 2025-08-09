// Last updated: 8/9/2025, 12:28:42 AM
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = x.length;
        for (int i = 0; i < n; i++) {
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Collections.reverseOrder());
        return list.size() < 3 ? -1 : list.get(0) + list.get(1) + list.get(2);
    }
}