// Last updated: 6/12/2026, 8:54:01 PM
1class Solution {
2    public String mapWordWeights(String[] words, int[] weights) {
3        StringBuilder sb = new StringBuilder();
4        for (String word : words) {
5            int sum = 0;
6            for (char c : word.toCharArray()) {
7                sum += weights[c - 'a'];
8            }
9            sum %= 26;
10            sb.append((char)('z' - sum));
11        }
12        return sb.toString();
13    }
14}