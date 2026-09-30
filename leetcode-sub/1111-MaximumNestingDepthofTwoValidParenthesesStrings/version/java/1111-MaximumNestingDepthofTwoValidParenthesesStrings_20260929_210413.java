// Last updated: 9/29/2026, 9:04:13 PM
1class Solution {
2
3    public int[] maxDepthAfterSplit(String seq) {
4        int d = 0;
5        int length = seq.length();
6        int[] ans = new int[length];
7        for (int i = 0; i < length; i++) {
8            if (seq.charAt(i) == '(') {
9                ++d;
10                ans[i] = d % 2;
11            } else {
12                ans[i] = d % 2;
13                --d;
14            }
15        }
16        return ans;
17    }
18}