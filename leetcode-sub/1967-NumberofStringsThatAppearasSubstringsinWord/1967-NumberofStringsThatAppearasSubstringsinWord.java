// Last updated: 6/29/2026, 2:25:57 AM
1class Solution {
2    public int numOfStrings(String[] patterns, String word) {
3        AhoCorasick ahoCorasick = new AhoCorasick();
4        for (String pattern : patterns) {
5            ahoCorasick.insert(pattern);
6        }
7        ahoCorasick.bfs();
8        return ahoCorasick.count(word);
9    }
10
11    class AhoCorasick {
12        TrieNode root = new TrieNode();
13        public void insert(String pattern) {
14            TrieNode node = root;
15            for (char ch : pattern.toCharArray()) {
16                if (node.child[ch - 'a'] == null) {
17                    node.child[ch - 'a'] = new TrieNode();
18                }
19                node = node.child[ch - 'a'];
20            }
21            node.count++;
22        }
23        public void bfs() {
24            Queue<TrieNode> queue = new ArrayDeque<>();
25            root.failureLink = root;
26            for (int i = 0; i < 26; i++) {
27                if (root.child[i] == null) {
28                    root.child[i] = root;
29                } 
30                else {
31                    root.child[i].failureLink = root;
32                    root.child[i].outputLink = null;
33                    queue.offer(root.child[i]);
34                }
35            }
36            while (!queue.isEmpty()) {
37                TrieNode node = queue.poll();
38                for (int i = 0; i < 26; i++) {
39                    TrieNode child = node.child[i];
40                    if (child == null) {
41                        node.child[i] = node.failureLink.child[i];
42                    } 
43                    else {
44                        child.failureLink = node.failureLink.child[i];
45                        child.outputLink = child.failureLink.count > 0 ? 
46                        child.failureLink : child.failureLink.outputLink;
47                        queue.offer(child);
48                    }
49                }
50            }
51        }
52
53        public int count(String text) {
54            TrieNode node = root;
55            int count = 0;
56            for (char ch : text.toCharArray()) {
57                node = node.child[ch - 'a'];
58                TrieNode match = node;
59                while (match != null) {
60                    count += match.count;
61                    match.count = 0;
62                    TrieNode next = match.outputLink;
63                    match.outputLink = null;
64                    match = next;
65                }
66            }
67            return count;
68        }
69
70        class TrieNode {
71            TrieNode[] child = new TrieNode[26];
72            TrieNode failureLink, outputLink;
73            int count = 0;
74        }
75    }
76}