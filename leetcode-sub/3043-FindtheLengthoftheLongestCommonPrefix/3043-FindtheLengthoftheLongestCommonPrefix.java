// Last updated: 5/20/2026, 8:07:31 PM
1class Solution {
2    public int longestCommonPrefix(int[] arr1, int[] arr2) {
3        int max = 0;
4        Trie trie = new Trie();
5        for (int num : arr1) {
6            trie.insert(String.valueOf(num));
7        }
8        for (int num : arr2) {
9            String s = String.valueOf(num);
10            for (int i = 1; i <= s.length(); i++) {
11                String prefix = s.substring(0, i);
12                if (trie.searchPrefix(prefix) == null) {
13                    break;
14                }
15                else {
16                    max = Math.max(max, i);
17                }
18            }
19        }
20        return max;
21    }
22    class Trie {
23        private TrieNode root;
24        
25        public Trie() {
26            root = new TrieNode();
27        }
28        
29        public void insert(String word) {
30            TrieNode node = root;
31            for (char ch : word.toCharArray()) {
32                if (node.child[ch - '0'] == null) {
33                    node.child[ch - '0'] = new TrieNode();
34                }
35                node = node.child[ch - '0'];
36            }
37            node.isEnd = true;
38        }   
39        
40        public boolean search(String word) {
41            TrieNode node = searchPrefix(word);
42            return node != null && node.isEnd;
43        }
44        
45        public boolean startsWith(String prefix) {
46            TrieNode node = searchPrefix(prefix);
47            return node != null;
48        }
49        public TrieNode searchPrefix(String word) {
50            TrieNode node = root;
51            for (char ch : word.toCharArray()) {
52                if (node.child[ch - '0'] == null) {
53                    return null;
54                }
55                node = node.child[ch - '0'];
56            }
57            return node;
58        }
59        class TrieNode {
60            TrieNode[] child = new TrieNode[10];
61            boolean isEnd = false;
62        }
63    }
64}