// Last updated: 4/5/2025, 4:59:16 PM
class TreeAncestor {

    int MAX_DEPTH = (int) (Math.log(50001) / Math.log(2) + 1); // log base 2
    int[][] pre = new int[50001][MAX_DEPTH + 1]; // pre[i][j] stores (2^j)th ancestor of node i
    List<List<Integer>> tree = new ArrayList<>();

    public TreeAncestor(int n, int[] parent) {
        for (int i = 0; i < n; ++i) tree.add(new ArrayList<>());
        for (int i = 0; i < n; ++i) Arrays.fill(pre[i], -1);

        // Step 1: Reconstruct tree in correct format, root to leaf
        for (int i = 1; i < n; ++i) {
            tree.get(parent[i]).add(i);
        }

        // Step 2: Prefill pre[i][j]
        preprocess(0, new int[n], 0);
    }

    private void preprocess(int cur, int[] traversal, int depth) {
        traversal[depth] = cur;

        // Fill ancestor for `cur` that are at distance of 2^i
        for (int i = 0; depth - (1 << i) >= 0; i++) {
            pre[cur][i] = traversal[depth - (1 << i)];
        }

        // Recursively fill ancestors for child nodes.
        for (int i = 0; i < tree.get(cur).size(); ++i) {
            preprocess(tree.get(cur).get(i), traversal, depth + 1);
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0) return node;
        for (int i = MAX_DEPTH; i >= 0 && node != -1; --i) {
            if ((k & (1 << i)) != 0) {
                node = pre[node][i];
            }
        }
        return node;
    }

}