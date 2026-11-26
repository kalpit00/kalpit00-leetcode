// Last updated: 11/25/2026, 8:26:24 PM
1class Solution {
2    public boolean canAliceWin(int n) {
3        boolean flag = false;      
4        int stonesToRemove = 10;
5        while (n >= stonesToRemove) {
6            n -= stonesToRemove;
7            stonesToRemove--;  
8            flag = !flag;      
9        }
10        return flag;
11    }
12}