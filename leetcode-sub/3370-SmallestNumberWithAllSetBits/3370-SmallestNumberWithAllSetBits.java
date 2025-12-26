// Last updated: 12/26/2025, 7:13:32 AM
1class Solution {
2    public long minInversionCount(int[] nums, int k) {
3        Set<Integer> set = new HashSet<>();
4        for (int num : nums) {
5            set.add(num);
6        }        
7        List<Integer> sorted = new ArrayList<>(set);
8        Collections.sort(sorted);
9        Map<Integer, Integer> map = new HashMap<>();
10        for (int i = 0; i < sorted.size(); i++) {
11            map.put(sorted.get(i), i);
12        }
13        int n = nums.length, m = sorted.size();
14        long min = Long.MAX_VALUE;
15        Window window = new Window(m);
16        for (int i = 0; i < k; i++) {
17            window.expand(map.get(nums[i]));
18        }
19        min = window.count;
20        for (int i = k; i < n; i++) {
21            window.shrink();
22            window.expand(map.get(nums[i]));
23            min = Math.min(min, window.count);
24        }
25        return min;
26    }
27    
28    class Window {
29        long count;
30        Deque<Integer> deque;
31        int m;
32        FenwickTree fenwickTree;
33        
34        public Window(int m) {
35            this.m = m;
36            count = 0;
37            deque = new ArrayDeque<>();
38            fenwickTree = new FenwickTree(m);
39        }
40        
41        public void expand(int x) {
42            // Count how many elements already in window are greater than x
43            count += fenwickTree.query(m - 1) - fenwickTree.query(x);
44            deque.addLast(x);
45            fenwickTree.update(x, 1);
46        }
47        
48        public void shrink() {
49            int x = deque.pollFirst();
50            // Count how many elements in window are less than x
51            count -= fenwickTree.query(x - 1);
52            fenwickTree.update(x, -1);
53        }
54    }
55    
56    class FenwickTree {
57        int[] tree;
58        int n;
59        public FenwickTree(int n) {
60            this.n = n;
61            this.tree = new int[n + 1];
62        }
63        
64        public int query(int index) {
65            if (index < 0) return 0;
66            int sum = 0;
67            index++;
68            while (index > 0) {
69                sum += tree[index];
70                index -= index & (-index);
71            }
72            return sum;
73        }
74
75        public void update(int index, int val) {
76            index++;
77            while (index < tree.length) {
78                tree[index] += val;
79                index += index & (-index);
80            }
81        }
82    }
83}