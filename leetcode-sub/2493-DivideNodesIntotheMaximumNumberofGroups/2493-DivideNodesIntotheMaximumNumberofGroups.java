// Last updated: 3/18/2026, 8:58:00 PM
class Solution {

    public int magnificentSets(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int m = edges.length;
        int[] head = new int[n];
        int[] to = new int[m << 1];
        int[] next = new int[m << 1];
        Arrays.fill(head, -1);
        for(int i = 0; i < m; i++) {
            int a = edges[i][0] - 1, b = edges[i][1] - 1;
            to[i << 1] = b;
            next[i << 1] = head[a];
            head[a] = i << 1;

            to[i << 1 | 1] = a;
            next[i << 1 | 1] = head[b];
            head[b] = i << 1 | 1;

            dsu.union(a, b);
        }
        
        Deque<Integer> queue = new ArrayDeque<>();
        int[] color = new int[n], groupCount = new int[n];
        for(int i = 0; i < n; i++) {
            int groups = 1;
            int[] colors = new int[n];

            queue.add(i);
            colors[i] = 1;

            while(!queue.isEmpty()) {
                groups++;
                int len = queue.size();
                for(int l = 0; l < len; l++) {
                    int current = queue.poll();
                    for(int j = head[current]; j != -1; j = next[j]) {
                        int node = to[j];
                        if(colors[node] == 0) {
                            colors[node] = groups;
                            queue.add(node);
                        }else if(colors[node] == colors[current]) return -1;
                    }
                }
            }
            int root = dsu.find(i);
            groupCount[root] = Math.max(groupCount[root], groups - 1);
        }
        int ans = 0;
        for(int i = 0; i < n; i++) ans += groupCount[i];
        return ans;
    }
}
class DSU {
    private final int[] root, rank;
    public DSU(int n) {
        this.root = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; ++i) {
            this.root[i] = i;
            this.rank[i] = 1;
        }
    }
    public int find(int x) {
        if(root[x] == x) return x;
        return root[x] = find(root[x]);
    }
    public void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if(rx == ry) return;
        if(rank[rx] > rank[ry]) {
            root[ry] = rx;
            rank[rx] += rank[ry];
        }else {
            root[rx] = ry;
            rank[rx] += rank[ry];
        }
    }
}