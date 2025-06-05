// Last updated: 6/4/2025, 11:39:33 PM
class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        DSU dsu = new DSU(26);
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int u = s1.charAt(i) - 'a', v = s2.charAt(i) - 'a';
            dsu.union(u, v);
        }
        Map<Integer, Character> map = new HashMap<>();
        for (char ch = 'z'; ch >= 'a'; ch--) {
            int parent = dsu.findParent(ch - 'a');
            map.put(parent, ch);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int parent = dsu.findParent(ch - 'a');
            sb.append(map.get(parent));
        }
        return sb.toString();
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