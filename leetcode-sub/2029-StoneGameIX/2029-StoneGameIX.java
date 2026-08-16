// Last updated: 8/15/2026, 8:22:02 PM
1class Solution {
2
3    public boolean stoneGameIX(int[] stones) {
4        int cnt0 = 0,
5            cnt1 = 0,
6            cnt2 = 0;
7        for (int val : stones) {
8            int type = val % 3;
9            if (type == 0) {
10                ++cnt0;
11            } else if (type == 1) {
12                ++cnt1;
13            } else {
14                ++cnt2;
15            }
16        }
17        if (cnt0 % 2 == 0) {
18            return cnt1 >= 1 && cnt2 >= 1;
19        }
20        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
21    }
22}