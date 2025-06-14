// Last updated: 6/13/2025, 10:18:49 PM
class Solution {
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] indegree = new int[n], res = new int[n];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int edge : edges) {
            indegree[edge]++;
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            stack.push(node); // use stack as we want "reverse" topo-order
            int neighbor = edges.get(node); // no for-neigh loop as only 1 neigh
            indegree[neighbor]--;
            if (indegree[neighbor] == 0) {
                queue.offer(neighbor);
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                continue;
            } // find length of cycle starting at node 'i'
            List<Integer> cycle = new ArrayList<>();
            int count = 0; // starting at i, go to next fav neighbor in cycle
            for (int j = i; indegree[j] != 0; j = edges.get(j)) {
                cycle.add(j);
                indegree[j] = 0; // visit the neighbor
                count++; // increase length of this cycle by 1
            }
            for (int node : cycle) {
                res[node] = count;
            } // for every node in the cycle, res is length of the cycle!
        } // in stack, we have all nodes NOT part of any cycles!
        while (!stack.isEmpty()) {
            int node = stack.pop();
            res[node] = res[edges.get(node)] + 1;
        } // ans for these nodes will simply be ans of their neighbor + 1
        return res;
    }
}
