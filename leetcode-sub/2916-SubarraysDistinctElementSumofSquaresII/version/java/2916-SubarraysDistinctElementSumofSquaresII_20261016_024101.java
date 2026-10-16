// Last updated: 10/16/2026, 2:41:01 AM
1class BIT {
2
3    int size;
4    long[] _tree1;
5    long[] _tree2;
6
7    public BIT(int n) {
8        this.size = n;
9        this._tree1 = new long[n + 2];
10        this._tree2 = new long[n + 2];
11    }
12
13    private int _lowbit(int index) {
14        return index & -index;
15    }
16
17    public void add(int left, int right, int delta) {
18        _add(left, delta);
19        _add(right + 1, -delta);
20    }
21
22    public long query(int left, int right) {
23        return _query(right) - _query(left - 1);
24    }
25
26    private void _add(int index, int delta) {
27        index += 1;
28        long rawIndex = index;
29        while (index <= size) {
30            _tree1[index] += delta;
31            _tree2[index] += rawIndex * delta;
32            index += _lowbit(index);
33        }
34    }
35
36    private long _query(int index) {
37        index += 1;
38        long rawIndex = index + 1;
39        if (index > size) {
40            index = size;
41        }
42        long res = 0;
43        while (index > 0) {
44            res += rawIndex * _tree1[index] - _tree2[index];
45            index -= _lowbit(index);
46        }
47        return res;
48    }
49}
50
51class Solution {
52
53    public int sumCounts(int[] A) {
54        int n = A.length;
55        long res = 0,
56            cur = 0;
57        BIT bit = new BIT(n + 10);
58        Map<Integer, Integer> seen = new HashMap<>();
59        long mod = 1000000007;
60        for (int i = 0; i < n; i++) {
61            int a = A[i];
62            int j = seen.getOrDefault(a, -1) + 1;
63            long q = bit.query(j, i);
64            cur = (cur + q * 2 + i - j + 1) % mod;
65            res = (res + cur) % mod;
66            bit.add(j, i, 1);
67            seen.put(a, i);
68        }
69        return (int) res;
70    }
71}