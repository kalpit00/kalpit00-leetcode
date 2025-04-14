// Last updated: 4/14/2025, 12:05:54 AM
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length, max = 1000, ans = 0;
        for (int j = 1; j < n - 1; j++) {
            FenwickTree left = new FenwickTree(max + 1);
            FenwickTree right = new FenwickTree(max + 1);
            for (int k = j + 1; k < n; k++) {
                right.update(arr[k], 1);
            } // Fill right tree with arr[k] (k > j)
            for (int i = 0; i < j; i++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    int lower = Math.max(0, arr[j] - b);
                    int upper = Math.min(max, arr[j] + b);
// For every k where |arr[j] - arr[k]| <= b, ensure |arr[i] - arr[k]| <= c
                    int minK = Math.max(lower, arr[i] - c);
                    int maxK = Math.min(upper, arr[i] + c);
                    if (minK <= maxK) {
                        ans += right.rangeQuery(minK, maxK);
                    }
                }
                left.update(arr[i], 1);
            }
            // Remove arr[j+1] from right for next iteration
            if (j + 1 < n)
                right = new FenwickTree(max + 1);  // Reset tree
        }
        return ans;
    }

    class FenwickTree {
        int[] tree;
        int n;
        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 2];
        }
        public void update(int index, int delta) {
            index++;
            while (index <= n) {
                tree[index] += delta;
                index += index & -index;
            }
        }
        public int query(int index) {
            int sum = 0;
            index++;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
        public int rangeQuery(int l, int r) {
            return query(r) - query(l - 1);
        }
    }
}
