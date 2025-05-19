// Last updated: 5/19/2025, 11:34:42 AM
class Solution {
    public int countComponents(int[] nums, int threshold) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num > threshold) {
                count++;
            }
            else {
                list.add(num);
            }
        }
        DSU dsu = new DSU(threshold + 1);
        for (int i : list) {
            for (int j = 2; i * j <= threshold; j++) {
                dsu.union(i, i * j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int num : list) {
            set.add(dsu.findParent(num));
        }  
        return count + set.size();
    }
    class DSU {
        int[] size, parent;
        int componentCount;
        public DSU(int n) {
            size = new int[n];
            parent = new int[n];
            componentCount = n;
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
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
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            componentCount--;
        }
    }
}