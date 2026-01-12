// Last updated: 1/12/2026, 1:19:14 PM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        SparseTable table = new SparseTable(nums);
4        int n = nums.length;
5        long sum = 0;
6        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
7        for (int i = 0; i < n; i++) {
8            int max = table.queryMax(0, i);
9            int min = table.queryMin(0, i);
10            pq.offer(new int[]{max - min, 0, i});
11        }
12        while (k > 0 && !pq.isEmpty()) {
13            int[] item = pq.poll();
14            sum += item[0];            
15            int l = item[1], r = item[2];
16            if (l + 1 <= r) {
17                int max = table.queryMax(l + 1, r);
18                int min = table.queryMin(l + 1, r); 
19                pq.offer(new int[]{max - min, l + 1, r});
20            }
21            k--;
22        }
23        return sum;
24    }
25    class SparseTable {
26        int[][][] table;
27        int k, n;
28        public SparseTable(int[] nums) {
29            n = nums.length;
30            k = (int) (Math.log(n) / Math.log(2)) + 1;
31            table = new int[n][k][2];
32            for (int i = 0; i < n; i++) {
33                table[i][0][0] = nums[i];
34                table[i][0][1] = nums[i];
35            }
36            for (int j = 1; j < k; j++) {
37                for (int i = 0; i + (1 << j) <= n; i++) {
38                    table[i][j][0] = Math.max(table[i][j - 1][0], table[i + (1 << (j - 1))][j - 1][0]);
39                    table[i][j][1] = Math.min(table[i][j - 1][1], table[i + (1 << (j - 1))][j - 1][1]);
40                }
41            }
42        }
43        public int queryMax(int l, int r) {
44            if (l > r) return Integer.MAX_VALUE;
45            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
46            return Math.max(table[l][x][0], table[r - (1 << x) + 1][x][0]);
47        }
48        public int queryMin(int l, int r) {
49            if (l > r) return Integer.MIN_VALUE;
50            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
51            return Math.min(table[l][x][1], table[r - (1 << x) + 1][x][1]);
52        }
53    }
54}