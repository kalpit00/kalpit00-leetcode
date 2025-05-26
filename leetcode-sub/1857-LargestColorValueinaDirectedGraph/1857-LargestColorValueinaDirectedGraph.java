// Last updated: 5/25/2025, 8:38:58 PM
class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        char[] color = colors.toCharArray();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        int[][] map = new int[n][26];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                map[i][color[i] - 'a'] = 1;
            }
        }
        int res = 0, idx = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            idx++;
            int max = getMax(map[node]);
            res = Math.max(res, max);
            for (int neighbor : adj.get(node)) {
                for (int i = 0; i < 26; i++) {
                    map[neighbor][i] = Math.max(map[neighbor][i], 
                    map[node][i] + (color[neighbor] - 'a' == i ? 1 : 0));
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return idx == n ? res : -1;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        return max;
    }
}
