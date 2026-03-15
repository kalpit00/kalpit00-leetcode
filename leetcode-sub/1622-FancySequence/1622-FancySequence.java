// Last updated: 3/14/2026, 9:00:00 PM
1class Fancy {
2    long mod = 1000000007;
3    FenwickTree bit;
4
5    public Fancy() {
6        bit = new FenwickTree();
7    }
8
9    public void append(int val) {
10        bit.append(val);
11    }
12
13    public void addAll(int inc) {
14        bit.addAll(inc);
15    }
16
17    public void multAll(int m) {
18        bit.multAll(m);
19    }
20
21    public int getIndex(int idx) {
22        return bit.getIndex(idx);
23    }
24    class FenwickTree {
25        List<long[]> tree; // each long[] = [value, multiplicand, addendum]
26        public FenwickTree() {
27            tree = new ArrayList<>();
28            tree.add(new long[]{0, 1, 0});
29        }
30
31        public void append(long val) {
32            tree.add(new long[]{val, 1, 0}); // val, multi=1, add=0
33        }
34        public void addAll(int inc) {
35            int index = tree.size() - 1;
36            while (index > 0) {
37                long[] node = tree.get(index);
38                node[2] = (node[2] + inc) % mod;
39                index -= index & (-index);
40            }
41        }
42
43        public void multAll(int m) {
44            int index = tree.size() - 1;
45            while (index > 0) {
46                long[] node = tree.get(index);
47                node[1] = (node[1] * m) % mod;
48                node[2] = (node[2] * m) % mod;
49                index -= index & (-index);
50            }
51        }
52
53        public int getIndex(int index) {
54            if (index >= tree.size() - 1) {
55                return -1;
56            } 
57            index++;
58            long res = tree.get(index)[0];
59            while (index < tree.size()) {
60                long[] node = tree.get(index);
61                res = (res * node[1]) % mod;
62                res = (res + node[2]) % mod;
63                index += index & (-index);
64            }
65            return (int) res;
66        }
67    }
68
69}
70