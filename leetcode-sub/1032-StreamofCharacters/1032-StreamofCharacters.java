// Last updated: 6/29/2026, 2:59:40 AM
1class StreamChecker {
2    Trie trie;
3    List<Character> list;
4    public StreamChecker(String[] words) {
5        trie = new Trie();
6        list = new ArrayList<>();
7        for (String word : words) {
8            trie.insert(word);
9        }
10    }
11    public boolean query(char letter) {
12        list.add(letter);
13        return trie.search(list);
14    }
15    class Trie {
16        private TrieNode root;
17        
18        public Trie() {
19            root = new TrieNode();
20        }
21        
22        public void insert(String word) {
23            TrieNode node = root;
24            for (int i = word.length() - 1; i >= 0; i--) {
25                char ch = word.charAt(i);
26                if (node.child[ch - 'a'] == null) {
27                    node.child[ch - 'a'] = new TrieNode();
28                }
29                node = node.child[ch - 'a'];
30            }
31            node.isEnd = true;
32        }   
33        
34        public boolean search(List<Character> word) {
35            TrieNode node = root;
36            for (int i = word.size() - 1; i >= 0; i--) {
37                char ch = word.get(i);
38                if (node.child[ch - 'a'] == null) {
39                    return false;
40                }
41                node = node.child[ch - 'a'];
42                if (node.isEnd) {
43                    return true;
44                }
45            }
46            return node.isEnd;
47        }
48        class TrieNode {
49            TrieNode[] child = new TrieNode[26];
50            boolean isEnd = false;
51        }
52    }
53}