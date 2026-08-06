// Last updated: 8/6/2026, 7:58:33 PM
1class Solution {
2    public long countBalanced(long low, long high) {
3        String a = String.valueOf(low - 1), b = String.valueOf(high);
4        int m = a.length(), n = b.length();
5        Map<String, Long> dp1 = new HashMap<>(), dp2 = new HashMap<>();
6        return solve(b, n, 0, 1, 0, 0, dp2) - solve(a, m, 0, 1, 0, 0, dp1);
7    }
8    private long solve(String num, int m, int idx, int tight, int sum, int parity, Map<String, Long> dp) {
9        if (idx == m) {
10            return sum == 0 ? 1 : 0;
11        }
12        String key = idx + "," + tight + "," + sum + "," + parity;
13        if (dp.containsKey(key)) {
14            return dp.get(key);
15        }
16        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;
17        long count = 0;
18        for (int i = 0; i <= limit; i++) {
19            int newTight = tight == 1 && i == limit ? 1 : 0;
20            int newSum = parity == 0 ? sum + i : sum - i;
21            int newParity = (parity + 1) % 2;
22            count += solve(num, m, idx + 1, newTight, newSum, newParity, dp);
23        }
24        dp.put(key, count);
25        return count;
26    }
27}