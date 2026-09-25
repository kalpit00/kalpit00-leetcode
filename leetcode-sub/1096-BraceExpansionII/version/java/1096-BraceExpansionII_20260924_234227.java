// Last updated: 9/24/2026, 11:42:27 PM
1class Solution {
2    Set<String> ans = new TreeSet<>();
3    public List<String> braceExpansionII(String expression) {
4        dfs(expression);
5        return new ArrayList<>(ans);
6    }
7    private void dfs(String s) {
8        int r = s.indexOf('}');
9        if (r == -1) {
10            ans.add(s);
11            return; // No braces left
12        }
13        int l = s.lastIndexOf('{', r); // Find matching '{'
14        String left = s.substring(0, l);
15        String right = s.substring(r + 1);
16        String mid = s.substring(l + 1, r); // Content inside { }
17        for (String middle : mid.split(",")) {
18            dfs(left + middle + right);
19        }
20    }
21}