// Last updated: 6/6/2026, 11:34:56 PM
1class Solution {
2    public TreeNode createBinaryTree(int[][] descriptions) {
3        boolean[] set = new boolean[100001];
4        TreeNode[] map = new TreeNode[100001];
5        for (int[] description : descriptions) {
6            int parent = description[0], child = description[1];
7            map[parent] = map[parent] == null ? new TreeNode(parent) :
8            map[parent];
9            map[child] = map[child] == null ? new TreeNode(child) : map[child];
10            set[child] = true;
11            if (description[2] == 1) {
12                map[parent].left = map[child];
13            }
14            else {
15                map[parent].right = map[child];
16            }
17        }
18        for (int i = 0; i < map.length; i++) {
19            if (map[i] == null) continue;
20            if (!set[i]) {
21                return map[i];
22            }
23        }
24        return null;
25    }
26}