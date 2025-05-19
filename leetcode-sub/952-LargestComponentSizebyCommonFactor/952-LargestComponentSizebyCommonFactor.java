// Last updated: 5/19/2025, 7:19:38 PM
class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int max = 1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] map = new int[max + 1];
        Arrays.fill(map, -1);
        boolean[] check = new boolean[max + 1];
        
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            map[nums[i]] = i;
        }
        for (int p = 2; p <= max; p++) {
            if (check[p]) {
                continue;
            }

            int first = -1;
            for (int div = p; div <= max; div += p) {
                if (map[div] >= 0) {
                    if (first == -1) {
                        first = map[div];
                    } else {
                        dsu.union(first, map[div]);
                    }
                }
                check[div] = true;
            }
        }
        
        return dsu.getMaxComponent();
    }

    class DSU {
        private int[] parent;
        private int[] size;
        private int maxSize;

        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            maxSize = 1;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        
        public int findParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
        
        public void union(int u, int v) {
            int pu = findParent(u), pv = findParent(v);
            if (pu == pv) {
                return;
            }
            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            maxSize = Math.max(maxSize, Math.max(size[pu], size[pv]));
        }
        
        public int getMaxComponent() {
            return maxSize;
        }
    }
}
