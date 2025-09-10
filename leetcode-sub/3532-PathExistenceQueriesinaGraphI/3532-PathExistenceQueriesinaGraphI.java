// Last updated: 9/9/2025, 8:05:14 PM
class Solution {
    
public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
int compId = 0;
component[0] = compId;
for (int i = 1; i < n; i++) {
    if (nums[i] - nums[i-1] <= maxDiff) {
        component[i] = compId;
    } else {
        compId++;
        component[i] = compId;
    }
}

// Answer queries
boolean[] response = new boolean[queries.length];
for (int i = 0; i < queries.length; i++) {
    int u = queries[i][0];
    int v = queries[i][1];
    response[i] = component[u] == component[v];
}
        return response;
    }

    int findParent(int[] parent, int node) {
    while (parent[node] != node) {
        parent[node] = parent[parent[node]]; // path compression
        node = parent[node];
    }
    return node;
}
}