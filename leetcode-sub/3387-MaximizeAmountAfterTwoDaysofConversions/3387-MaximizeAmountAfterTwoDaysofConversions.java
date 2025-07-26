// Last updated: 7/26/2025, 3:24:30 PM
class Solution {
    public double maxAmount(String src, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        int m = pairs1.size(), n = pairs2.size();
        Map<String, Double> dp = new HashMap<>();
        dp.put(src, 1.0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < m; j++) {
                String u = pairs1.get(j).get(0), v = pairs1.get(j).get(1);
                dp.putIfAbsent(u, 0.0);
                dp.putIfAbsent(v, 0.0);
                dp.put(v, Math.max(dp.get(v), dp.get(u) * rates1[j]));
                dp.put(u, Math.max(dp.get(u), dp.get(v) / rates1[j]));
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < n; j++) {
                String u = pairs2.get(j).get(0), v = pairs2.get(j).get(1);
                dp.putIfAbsent(u, 0.0);
                dp.putIfAbsent(v, 0.0);
                dp.put(v, Math.max(dp.get(v), dp.get(u) * rates2[j]));
                dp.put(u, Math.max(dp.get(u), dp.get(v) / rates2[j]));
            }
        }
        return dp.get(src);
    }
}