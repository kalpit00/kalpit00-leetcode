// Last updated: 10/1/2026, 11:56:31 PM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3        List<String> res = new ArrayList<>();
4        helper(res, 0, 0, new StringBuilder(), n);
5        return res;
6    }
7    public void helper (List<String> res, int left, int right, StringBuilder s, int n) {
8        if (s.length() == n * 2) {
9            res.add(s.toString());
10            return;
11        }
12        if (left < n) {
13            s.append("(");
14            helper(res, left + 1, right, s, n);
15            s.deleteCharAt(s.length() - 1);
16        }
17        if (right < left) {
18            s.append(")");
19            helper(res, left, right + 1, s, n);
20            s.deleteCharAt(s.length() - 1);
21        }
22    }
23}