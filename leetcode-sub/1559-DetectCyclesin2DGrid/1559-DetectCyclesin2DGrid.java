// Last updated: 4/25/2026, 9:47:28 PM
class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // every node is its own group
        int[] groups = new int[rows * cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                groups[i * cols + j] = i * cols + j;
            }
        }

        // we merge n1 and n2 if they are neighbours (adjacent + same value)
        // if they already in the same group, then we found a cycle!

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int id = i * cols + j;
                char c = grid[i][j];

                // find all neighbours, get all neighbour groups
                // if already. merged --> cycle!


                if (i + 1 < rows && grid[i+1][j] == c) {
                    int aGroup = find(id, groups);
                    int bGroup = find( (i + 1) * cols + j, groups);

                    if (aGroup == bGroup) return true;
                    groups[aGroup] = bGroup;
                }

                if (j + 1 < cols && grid[i][j+1] == c) {
                    int aGroup = find(id, groups);
                    int bGroup = find( i * cols + j + 1, groups);

                    if (aGroup == bGroup) return true;
                    groups[aGroup] = bGroup;
                }
            }
        }

        return false;
    }

    private int find(int id, int[] groups) {
        if (id == groups[id]) return id;
        groups[id] = find(groups[id], groups);
        return groups[id];
    }
}

/**

undirecte dgraph --> union find

each node starts in its own group

then we keep merging neighbouring nodes 

if we find that 2 nodes are already in the same group --> it means we've found a cycle


 */