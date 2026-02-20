// Last updated: 2/19/2026, 9:17:08 PM
1class Solution {
2    public String makeLargestSpecial(String s) {
3        return dfs(s.toCharArray(), 0, s.length());
4    }
5    private String dfs(char[] arr, int start, int end) {
6        List<String> res = new ArrayList<>();
7        int count = 0, i = start;
8        for (int j = start; j < end; j++) {
9            count += arr[j] == '1' ? 1 : -1;
10            if (count == 0) {
11                res.add('1' + dfs(arr, i + 1, j) + '0');
12                i = j + 1;
13            }
14        }
15        Collections.sort(res, Collections.reverseOrder());
16        return String.join("", res);
17    }
18}