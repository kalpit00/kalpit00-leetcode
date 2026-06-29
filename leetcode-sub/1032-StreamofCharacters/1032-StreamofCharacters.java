// Last updated: 6/29/2026, 2:57:14 AM
1class StreamChecker {
2    Trie trie;
3    StringBuilder sb;
4    public StreamChecker(String[] words) {
5        trie = new Trie();
6        sb = new StringBuilder();
7        for (String word : words) {
8            trie.insert(word);
9        }
10    }
11    
12    public boolean query(char letter) {
13        sb.append(letter);
14        return trie.search(sb.toString());
15    }
16    class Trie {
17        private TrieNode root;
18        
19        public Trie() {
20            root = new TrieNode();
21        }
22        
23        public void insert(String word) {
24            TrieNode node = root;
25            for (int i = word.length() - 1; i >= 0; i--) {
26                char ch = word.charAt(i);
27                if (node.child[ch - 'a'] == null) {
28                    node.child[ch - 'a'] = new TrieNode();
29                }
30                node = node.child[ch - 'a'];
31            }
32            node.isEnd = true;
33        }   
34        
35        public boolean search(String word) {
36            TrieNode node = root;
37            for (int i = word.length() - 1; i >= 0; i--) {
38                char ch = word.charAt(i);
39                if (node.child[ch - 'a'] == null) {
40                    return false;
41                }
42                if (node.child[ch - 'a'].isEnd) {
43                    return true;
44                }
45                node = node.child[ch - 'a'];
46            }
47            return false;
48        }
49        class TrieNode {
50            TrieNode[] child = new TrieNode[26];
51            boolean isEnd = false;
52        }
53    }
54}