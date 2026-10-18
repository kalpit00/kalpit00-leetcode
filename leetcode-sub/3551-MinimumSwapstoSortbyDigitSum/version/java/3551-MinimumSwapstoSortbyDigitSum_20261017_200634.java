// Last updated: 10/17/2026, 8:06:34 PM
1class Solution {
2
3    public int minSwaps(int[] nums) {
4        int n = nums.length;
5        int[] digitSum = new int[n];
6        for (int i = 0; i < n; i++) {
7            int x = nums[i],
8                sum = 0;
9            while (x > 0) {
10                sum += x % 10;
11                x /= 10;
12            }
13            digitSum[i] = sum;
14        }
15
16        Integer[] indices = new Integer[n];
17        for (int i = 0; i < n; i++) {
18            indices[i] = i;
19        }
20        Arrays.sort(indices, (a, b) -> {
21            if (digitSum[a] != digitSum[b]) {
22                return Integer.compare(digitSum[a], digitSum[b]);
23            }
24            return Integer.compare(nums[a], nums[b]);
25        });
26
27        int[] targetPos = new int[n];
28        for (int pos = 0; pos < n; pos++) {
29            targetPos[indices[pos]] = pos;
30        }
31
32        int[] parent = new int[n];
33        for (int i = 0; i < n; i++) {
34            parent[i] = i;
35        }
36        int components = n;
37
38        for (int i = 0; i < n; i++) {
39            int ri = find(parent, i);
40            int rj = find(parent, targetPos[i]);
41            if (ri != rj) {
42                parent[ri] = rj;
43                components--;
44            }
45        }
46
47        return n - components;
48    }
49
50    private int find(int[] parent, int x) {
51        if (parent[x] != x) {
52            parent[x] = find(parent, parent[x]);
53        }
54        return parent[x];
55    }
56}