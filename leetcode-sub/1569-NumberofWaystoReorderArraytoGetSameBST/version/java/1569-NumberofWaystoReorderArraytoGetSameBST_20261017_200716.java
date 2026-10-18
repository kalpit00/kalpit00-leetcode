// Last updated: 10/17/2026, 8:07:16 PM
1class Solution {
2    private long mod = (long)1e9 + 7;
3    private long[][] table;
4
5    public int numOfWays(int[] nums) {
6        int m = nums.length;
7        
8        // Table of Pascal's triangle
9        table = new long[m][m];
10        for (int i = 0; i < m; ++i) {
11            table[i][0] = table[i][i] = 1;
12        }
13        for (int i = 2; i < m; i++) {
14            for (int j = 1; j < i; j++) {
15                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % mod;
16            }
17        }
18        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
19        return (int)((dfs(arrList) - 1) % mod);
20    }
21
22    private long dfs(List<Integer> nums) {
23        int m = nums.size();
24        if (m < 3) {
25            return 1;
26        }
27
28        List<Integer> leftNodes = new ArrayList<>();
29        List<Integer> rightNodes = new ArrayList<>();
30        for (int i = 1; i < m; ++i) {
31            if (nums.get(i) < nums.get(0)) {
32                leftNodes.add(nums.get(i));
33            } else {
34                rightNodes.add(nums.get(i));
35            }
36        }
37        long leftWays = dfs(leftNodes) % mod;
38        long rightWays = dfs(rightNodes) % mod;
39
40        return (((leftWays * rightWays) % mod) * table[m - 1][leftNodes.size()]) % mod;
41    }
42}