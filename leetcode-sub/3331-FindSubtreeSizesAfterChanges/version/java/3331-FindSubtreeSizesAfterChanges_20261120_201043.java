// Last updated: 11/20/2026, 8:10:43 PM
1class Solution {
2    public int[] findSubtreeSizes(int[] parent, String s) {
3        int n = parent.length;
4        List<Integer>[] children = new ArrayList[n];
5        for (int i = 0; i < n; i++) {
6            children[i] = new ArrayList<>();
7        }
8        for (int i = 1; i < n; i++) {
9            children[parent[i]].add(i);
10        }
11
12        int[] last = new int[26];
13        Arrays.fill(last, -1);
14        int[] saved = new int[n];
15        int[] size = new int[n];
16        Arrays.fill(size, 1);
17
18        int[] stack = new int[2 * n];
19        int top = 0;
20        stack[top++] = 0;
21
22        while (top > 0) {
23            int x = stack[--top];
24
25            if (x >= 0) {
26                int c = s.charAt(x) - 'a';
27                saved[x] = last[c];
28                last[c] = x;
29                stack[top++] = ~x;
30                for (int ch : children[x]) {
31                    stack[top++] = ch;
32                }
33            } else {
34                x = ~x;
35                int c = s.charAt(x) - 'a';
36                last[c] = saved[x];
37                if (x != 0) {
38                    int newParent = (saved[x] != -1) ? saved[x] : parent[x];
39                    size[newParent] += size[x];
40                }
41            }
42        }
43        return size;
44    }
45}