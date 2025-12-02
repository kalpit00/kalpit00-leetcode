// Last updated: 12/1/2025, 10:32:30 PM
1class Solution {
2    public int countTrapezoids(int[][] points) {
3        Map<Integer, Integer> map = new HashMap<>();
4        int mod = 1000000007;
5        long count = 0, sum = 0;
6        for (int[] point : points) {
7            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
8        }
9        for (int n : map.values()) {
10            long edge = ((long) n * (n - 1)) / 2;
11            count += edge * sum;
12            sum += edge;
13            count %= mod;
14            sum %= mod;
15        }
16        return (int) count;
17    }
18}