// Last updated: 8/6/2026, 7:58:05 PM
1class Solution {
2    public long countBalanced(long low, long high) {
3        String a = String.valueOf(low - 1), b = String.valueOf(high);
4        int m = a.length(), n = b.length();
5        Map<String, Long> dp1 = new HashMap<>();
6        Map<String, Long> dp2 = new HashMap<>();
7        return solve(b, n, 0, 1, 0, 0, dp2) - solve(a, m, 0, 1, 0, 0, dp1);
8    }
9
10    private long solve(String num, int m, int idx, int tight, int sum, int parity, Map<String, Long> dp) {
11        if (idx == m) {
12            return sum == 0 ? 1 : 0;
13        }
14        String key = idx + "," + tight + "," + sum + "," + parity;
15        if (dp.containsKey(key)) {
16            return dp.get(key);
17        }
18        int limit = tight == 1 ? num.charAt(idx) - '0' : 9;
19        long count = 0;
20        for (int i = 0; i <= limit; i++) {
21            int newTight = tight == 1 && i == limit ? 1 : 0;
22            int newSum = parity == 0 ? sum + i : sum - i;
23            int newParity = (parity + 1) % 2;
24            count += solve(num, m, idx + 1, newTight, newSum, newParity, dp);
25        }
26        dp.put(key, count);
27        return count;
28    }
29}