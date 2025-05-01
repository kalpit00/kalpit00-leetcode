// Last updated: 5/1/2025, 7:56:29 PM
class Fancy {
    long mod = 1000000007;
    FenwickTree bit;

    public Fancy() {
        bit = new FenwickTree();
    }

    public void append(int val) {
        bit.append(val);
    }

    public void addAll(int inc) {
        bit.addAll(inc);
    }

    public void multAll(int m) {
        bit.multAll(m);
    }

    public int getIndex(int idx) {
        return bit.getIndex(idx);
    }
    class FenwickTree {
        List<long[]> tree; // each long[] = [value, multiplicand, addendum]
        public FenwickTree() {
            tree = new ArrayList<>();
            tree.add(new long[]{0, 1, 0});
        }

        public void append(long val) {
            tree.add(new long[]{val, 1, 0}); // val, multi=1, add=0
        }
        public void addAll(int inc) {
            int index = tree.size() - 1;
            while (index > 0) {
                long[] node = tree.get(index);
                node[2] = (node[2] + inc) % mod;
                index -= index & (-index);
            }
        }

        public void multAll(int m) {
            int index = tree.size() - 1;
            while (index > 0) {
                long[] node = tree.get(index);
                node[1] = (node[1] * m) % mod;
                node[2] = (node[2] * m) % mod;
                index -= index & (-index);
            }
        }

        public int getIndex(int index) {
            if (index >= tree.size() - 1) {
                return -1;
            } 
            index++;
            long res = tree.get(index)[0];
            while (index < tree.size()) {
                long[] node = tree.get(index);
                res = (res * node[1]) % mod;
                res = (res + node[2]) % mod;
                index += index & (-index);
            }
            return (int) res;
        }
    }

}
