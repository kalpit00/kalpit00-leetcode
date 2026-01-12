// Last updated: 1/12/2026, 1:18:13 PM
1class Solution {
2    public long maxTotalValue(int[] nums, int k) {
3        SparseTable table = new SparseTable(nums);
4        int n = nums.length;
5        long sum = 0;
6        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> 
7        Long.compare(b[0], a[0]));
8        for (int i = 0; i < n; i++) {
9            int max = table.queryMax(0, i);
10            int min = table.queryMin(0, i);
11            pq.offer(new long[]{max - min, 0, i});
12        }
13        while (k > 0 && !pq.isEmpty()) {
14            long[] item = pq.poll();
15            sum += item[0];            
16            int l = (int) item[1], r = (int) item[2];
17            if (l + 1 <= r) {
18                int max = table.queryMax(l + 1, r);
19                int min = table.queryMin(l + 1, r); 
20                pq.offer(new long[]{max - min, l + 1, r});
21            }
22            k--;
23        }
24        return sum;
25    }
26    class SparseTable {
27        int[][][] table;
28        int k, n;
29        public SparseTable(int[] nums) {
30            n = nums.length;
31            k = (int) (Math.log(n) / Math.log(2)) + 1;
32            table = new int[n][k][2];
33            for (int i = 0; i < n; i++) {
34                table[i][0][0] = nums[i];
35                table[i][0][1] = nums[i];
36            }
37            for (int j = 1; j < k; j++) {
38                for (int i = 0; i + (1 << j) <= n; i++) {
39                    table[i][j][0] = Math.max(table[i][j - 1][0], table[i + (1 << (j - 1))][j - 1][0]);
40                    table[i][j][1] = Math.min(table[i][j - 1][1], table[i + (1 << (j - 1))][j - 1][1]);
41                }
42            }
43        }
44        public int queryMax(int l, int r) {
45            if (l > r) return Integer.MAX_VALUE;
46            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
47            return Math.max(table[l][x][0], table[r - (1 << x) + 1][x][0]);
48        }
49        public int queryMin(int l, int r) {
50            if (l > r) return Integer.MIN_VALUE;
51            int x = 31 - Integer.numberOfLeadingZeros(r - l + 1);
52            return Math.min(table[l][x][1], table[r - (1 << x) + 1][x][1]);
53        }
54    }
55}