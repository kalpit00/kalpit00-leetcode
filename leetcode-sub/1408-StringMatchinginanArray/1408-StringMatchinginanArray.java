// Last updated: 6/29/2026, 2:36:54 AM
1class Solution {
2    public List<String> stringMatching(String[] words) {
3        AhoCorasick ahoCorasick = new AhoCorasick();
4        int n = words.length;
5        for (int i = 0; i < n; i++) {
6            ahoCorasick.insert(words[i], i);
7        }
8        ahoCorasick.bfs();
9        boolean[] visited = new boolean[n];
10        for (int i = 0; i < n; i++) {
11            ahoCorasick.find(words[i], i, visited);
12        }
13        List<String> res = new ArrayList<>();
14        for (int i = 0; i < n; i++) {
15            if (visited[i]) {
16                res.add(words[i]);
17            }
18        }
19        return res;
20    }
21
22    class AhoCorasick {
23        TrieNode root = new TrieNode();
24
25        public void insert(String pattern, int i) {
26            TrieNode node = root;
27            for (char ch : pattern.toCharArray()) {
28                if (node.child[ch - 'a'] == null) {
29                    node.child[ch - 'a'] = new TrieNode();
30                }
31                node = node.child[ch - 'a'];
32            }
33            node.count++;
34            node.indices.add(i);
35        }
36
37        public void bfs() {
38            Queue<TrieNode> queue = new ArrayDeque<>();
39            root.failureLink = root;
40            for (int i = 0; i < 26; i++) {
41                if (root.child[i] == null) {
42                    root.child[i] = root;
43                } 
44                else {
45                    root.child[i].failureLink = root;
46                    root.child[i].outputLink = null;
47                    queue.offer(root.child[i]);
48                }
49            }
50            while (!queue.isEmpty()) {
51                TrieNode node = queue.poll();
52                for (int i = 0; i < 26; i++) {
53                    TrieNode child = node.child[i];
54                    if (child == null) {
55                        node.child[i] = node.failureLink.child[i];
56                    } 
57                    else {
58                        child.failureLink = node.failureLink.child[i];
59                        child.outputLink = child.failureLink.count > 0 ? 
60                        child.failureLink : child.failureLink.outputLink;
61                        queue.offer(child);
62                    }
63                }
64            }
65        }
66
67        public void find(String text, int i, boolean[] visited) {
68            TrieNode node = root;
69            for (char ch : text.toCharArray()) {
70                node = node.child[ch - 'a'];
71                TrieNode match = node;
72                while (match != null) {
73                    for (int idx : match.indices) {
74                        if (idx == i) continue;
75                        visited[idx] = true;
76                    }
77                    match = match.outputLink;
78                }
79            }
80        }
81
82        class TrieNode {
83            TrieNode[] child = new TrieNode[26];
84            TrieNode failureLink, outputLink;
85            int count = 0;
86            List<Integer> indices = new ArrayList<>();
87        }
88    }
89}