// Last updated: 6/6/2026, 11:30:40 PM
1class Solution {
2    public TreeNode createBinaryTree(int[][] descriptions) {
3        Map<Integer, TreeNode> map = new HashMap<>();
4        Set<Integer> children = new HashSet<>();
5        for (int[] description : descriptions) {
6            int parent = description[0], child = description[1];
7            map.putIfAbsent(parent, new TreeNode(parent));
8            map.putIfAbsent(child, new TreeNode(child));
9            children.add(child);
10            if (description[2] == 1) {
11                map.get(parent).left = map.get(child);
12            }
13            else {
14                map.get(parent).right = map.get(child);
15            }
16        }
17        for (int node : map.keySet()) {
18            if (!children.contains(node)) {
19                return map.get(node);
20            }
21        }
22        return null;
23    }
24}