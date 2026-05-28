// Last updated: 5/27/2026, 9:04:38 PM
1class Solution {
2    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
3        int m = wordsQuery.length, n = wordsContainer.length;
4        int minIdx = 0, minLen = Integer.MAX_VALUE;
5        int[] res = new int[m];
6        Trie trie = new Trie();        
7        for (int i = 0; i < n; i++) {
8            if (wordsContainer[i].length() < minLen) {
9                minLen = wordsContainer[i].length();
10                minIdx = i;
11            }
12            trie.insert(wordsContainer[i], i);
13        }
14        for (int i = 0; i < m; i++) {
15            int ans = trie.searchPrefix(wordsQuery[i]);
16            res[i] = ans == -1 ? minIdx : ans;
17        }
18        return res;
19    }
20
21    class Trie {
22        private TrieNode root;
23
24        public Trie() {
25            root = new TrieNode();
26        }
27
28        public void insert(String word, int index) {
29            int length = word.length();
30            TrieNode node = root;
31            for (int i = length - 1; i >= 0; i--) {
32                char ch = word.charAt(i);
33                if (node.child[ch - 'a'] == null) {
34                    node.child[ch - 'a'] = new TrieNode();
35                }
36                node = node.child[ch - 'a'];
37                if (node.ans == -1 || length < node.length) {
38                    node.ans = index;
39                    node.length = length;
40                }
41            }
42        }
43
44        public int searchPrefix(String word) {
45            TrieNode node = root;
46            for (int i = word.length() - 1; i >= 0; i--) {
47                char ch = word.charAt(i);
48                if (node.child[ch - 'a'] == null) {
49                    break;
50                }
51                node = node.child[ch - 'a'];
52            }
53            return node == root ? -1 : node.ans;
54        }
55
56        class TrieNode {
57            TrieNode[] child = new TrieNode[26];
58            int ans = -1;
59            int length = Integer.MAX_VALUE;
60        }
61    }
62}
63