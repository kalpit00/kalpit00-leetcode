// Last updated: 10/28/2026, 2:18:08 AM
1class Solution {
2    public int slidingPuzzle(int[][] board) {
3        int[][] dir = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
4        String target = "123450";
5        StringBuilder sb = new StringBuilder();
6        for (int i = 0; i < board.length; i++) {
7            for (int j = 0; j < board[0].length; j++) {
8                sb.append(board[i][j]);
9            }
10        }
11        Queue<String> queue1 = new LinkedList<>();
12        Queue<String> queue2 = new LinkedList<>();
13        Set<String> visited1 = new HashSet<>();
14        Set<String> visited2 = new HashSet<>();
15        queue1.offer(sb.toString());
16        queue2.offer(target);
17        visited1.add(sb.toString());
18        visited2.add(target);
19        int steps = 0;
20        while (!queue1.isEmpty() && !queue2.isEmpty()) {
21            if (queue1.size() > queue2.size()) {
22                Queue<String> tempQueue = queue1;
23                queue1 = queue2;
24                queue2 = tempQueue;
25                Set<String> tempSet = visited1;
26                visited1 = visited2;
27                visited2 = tempSet;
28            }
29            int size = queue1.size();
30            for (int k = 0; k < size; k++) {
31                String node = queue1.poll();
32                if (visited2.contains(node)) {
33                    return steps;
34                }
35                int i = node.indexOf('0');
36                for (int j : dir[i]) {
37                    String neighbor = swap(node.toCharArray(), i, j);
38                    if (!visited1.contains(neighbor)) {
39                        queue1.offer(neighbor);
40                        visited1.add(neighbor);
41                    }
42                }
43            }
44            steps++;
45        }
46        return -1;
47    }
48    private String swap(char[] s, int i, int j) {
49        char temp = s[i];
50        s[i] = s[j];
51        s[j] = temp;
52        return new String(s);
53    }
54}