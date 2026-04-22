// Last updated: 4/21/2026, 9:41:01 PM
1class Solution {
2    public List<String> twoEditWords(String[] queries, String[] dictionary) {
3        List<String> res = new LinkedList();
4        Set<String> set = new HashSet();
5        for (String word : dictionary) {
6            set.add(word);
7        }
8        for (String query : queries) {
9            if (set.contains(query) || helper(query, set) == true) {
10                res.add(query);
11            }
12        }
13        return res;
14    }
15    private static boolean helper (String word, Set<String> set) {
16        int n = word.length();
17        if (n <= 2) {
18            return true;
19        }
20        for (String mask : set) {
21            int count = 0;
22            for (int i = 0; i < n; i++) {
23                if (word.charAt(i) == mask.charAt(i)) {
24                    count++;
25                }
26                if (count == n - 2) {
27                    return true;
28                }
29            }
30        }
31        return false;
32    }
33}