// Last updated: 4/28/2025, 8:53:33 PM
class TreeAncestor {
    int[][] table;
    public TreeAncestor(int n, int[] parent) {
        int m = parent.length;
        int k = (int) (Math.log(m) / Math.log(2)) + 1;
        table = new int[m][k]; // m x log(m)
        for (int i = 0; i < m; i++) {
            Arrays.fill(table[i], -1);
        }
        for (int i = 0; i < m; i++) {
            table[i][0] = parent[i];
        }
        for (int j = 1; j < k; j++) {
            for (int i = 0; i < m; i++) {
                if (table[i][j - 1] != -1) {
                    table[i][j] = table[table[i][j - 1]][j - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = table[0].length; j >= 0; j--) {
            if (node == -1) {
                break;
            }
            if ((k & (1 << j)) != 0) {
                node = table[node][j];
            }
        }
        return node;
    }
}