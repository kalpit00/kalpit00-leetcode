// Last updated: 5/1/2025, 7:58:58 PM
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
        long[][] tree;
        int size;

        public FenwickTree() {
            tree = new long[100001][3];
            tree[0][0] = 0; tree[0][1] = 1; tree[0][2] = 0;
            size = 0;
        }

        public void append(long val) {
            size++;
            tree[size][0] = val;
            tree[size][1] = 1;
            tree[size][2] = 0;
        }

        public void addAll(int inc) {
            int index = size;
            while (index > 0) {
                tree[index][2] = (tree[index][2] + inc) % mod;
                index -= index & (-index);
            }
        }

        public void multAll(int m) {
            int index = size;
            while (index > 0) {
                tree[index][1] = (tree[index][1] * m) % mod;
                tree[index][2] = (tree[index][2] * m) % mod;
                index -= index & (-index);
            }
        }

        public int getIndex(int index) {
            if (index >= size) {
                return -1;
            } 
            index++;
            long res = tree[index][0];
            while (index <= size) {
                res = (res * tree[index][1]) % mod;
                res = (res + tree[index][2]) % mod;
                index += index & (-index);
            }
            return (int) res;
        }
    }
}
