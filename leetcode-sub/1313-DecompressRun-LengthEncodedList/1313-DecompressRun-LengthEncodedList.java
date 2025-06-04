// Last updated: 6/4/2025, 2:07:59 AM
class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Trie trie = new Trie();
        for (String str : forbidden) {
            trie.insert(str);
        }
        char[] s = word.toCharArray();
        int n = s.length, left = 0, right = 0, max = 0;
        while (right < n) {
            int i = trie.searchSuffix(s, left, right);
            right++;
            if (i != -1) {
                left = i + 1;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
    class Trie {
        public TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            int n = word.length();
            TrieNode node = root;
            for (int i = n - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (node.child[ch - 'a'] == null) {
                    node.child[ch - 'a'] = new TrieNode();
                }
                node = node.child[ch - 'a'];
            }
            node.isEnd = true;
        } 
// find 'last' index of a Tnode with isEnd true -> a forbidden word ends there
        public int searchSuffix(char[] s, int left, int right) {
            TrieNode node = root; // s[left ... right] from right to left, i--
            for (int i = right; i >= left; i--) {
                if (node.child[s[i] - 'a'] == null) {
                    break;
                }
                node = node.child[s[i] - 'a'];
                if (node.isEnd) {
                    return i; // [left ... i ... right]
                } // [left, i] invalid range as some forbidden word ends at 'i'
            } // [i + 1, right] still valid, so notice we set left = i + 1
            return -1;
        } // no forbidden words' suffix found in [left, right], ret -1
        
        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            boolean isEnd = false;
        }
    }
}