// Last updated: 5/4/2025, 3:30:37 PM
class Fancy {
    final int MOD = 1_000_000_007;
    SegmentTree segmentTree;
    int size;

    public Fancy() {
        segmentTree = new SegmentTree(100_000); // Max 10^5 ops
        size = 0;
    }

    public void append(int val) {
        segmentTree.pointUpdate(size, val);
        size++;
    }

    public void addAll(int inc) {
        if (size > 0) {
            segmentTree.rangeAdd(0, size - 1, inc);
        }
    }

    public void multAll(int m) {
        if (size > 0) {
            segmentTree.rangeMul(0, size - 1, m);
        }
    }

    public int getIndex(int idx) {
        if (idx >= size) return -1;
        return segmentTree.pointQuery(idx);
    }
}

class SegmentTree {
    final int MOD = 1_000_000_007;
    int[] tree, lazyAdd, lazyMul;
    int size;

    public SegmentTree(int n) {
        size = n;
        tree = new int[4 * n];
        lazyAdd = new int[4 * n];
        lazyMul = new int[4 * n];
        Arrays.fill(lazyMul, 1);  // Multiplicative identity
    }

    private void push(int node, int l, int r) {
        if (lazyMul[node] != 1 || lazyAdd[node] != 0) {
            tree[node] = (int)(((long)tree[node] * lazyMul[node]) % MOD);
            tree[node] = (tree[node] + (int)(((long)(r - l + 1) * lazyAdd[node]) % MOD)) % MOD;
            if (l != r) {
                propagate(node, lazyMul[node], lazyAdd[node]);
            }
            lazyMul[node] = 1;
            lazyAdd[node] = 0;
        }
    }

    private void propagate(int node, int mul, int add) {
        applyLazy(node * 2, mul, add);
        applyLazy(node * 2 + 1, mul, add);
    }

    private void applyLazy(int node, int mul, int add) {
        lazyMul[node] = (int)((1L * lazyMul[node] * mul) % MOD);
        lazyAdd[node] = (int)((1L * lazyAdd[node] * mul + add) % MOD);
    }

    public void pointUpdate(int idx, int val) {
        pointUpdate(1, 0, size - 1, idx, val);
    }

    private void pointUpdate(int node, int l, int r, int idx, int val) {
        push(node, l, r);
        if (l == r) {
            tree[node] = val % MOD;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            pointUpdate(node * 2, l, mid, idx, val);
        } else {
            pointUpdate(node * 2 + 1, mid + 1, r, idx, val);
        }
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    public void rangeAdd(int ql, int qr, int val) {
        rangeAdd(1, 0, size - 1, ql, qr, val);
    }

    private void rangeAdd(int node, int l, int r, int ql, int qr, int val) {
        push(node, l, r);
        if (qr < l || ql > r) return;
        if (ql <= l && r <= qr) {
            applyLazy(node, 1, val);
            push(node, l, r);
            return;
        }
        int mid = (l + r) / 2;
        rangeAdd(node * 2, l, mid, ql, qr, val);
        rangeAdd(node * 2 + 1, mid + 1, r, ql, qr, val);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    public void rangeMul(int ql, int qr, int val) {
        rangeMul(1, 0, size - 1, ql, qr, val);
    }

    private void rangeMul(int node, int l, int r, int ql, int qr, int val) {
        push(node, l, r);
        if (qr < l || ql > r) return;
        if (ql <= l && r <= qr) {
            applyLazy(node, val, 0);
            push(node, l, r);
            return;
        }
        int mid = (l + r) / 2;
        rangeMul(node * 2, l, mid, ql, qr, val);
        rangeMul(node * 2 + 1, mid + 1, r, ql, qr, val);
        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    public int pointQuery(int idx) {
        return pointQuery(1, 0, size - 1, idx);
    }

    private int pointQuery(int node, int l, int r, int idx) {
        push(node, l, r);
        if (l == r) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            return pointQuery(node * 2, l, mid, idx);
        } else {
            return pointQuery(node * 2 + 1, mid + 1, r, idx);
        }
    }
}
