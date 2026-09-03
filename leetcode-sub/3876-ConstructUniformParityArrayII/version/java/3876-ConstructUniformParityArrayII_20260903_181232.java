// Last updated: 9/3/2026, 6:12:32 PM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int mn = nums1[0];
4        // test !!!!
5        boolean hasOdd = false;
6        for (int v : nums1) {
7            if (v < mn) {
8                mn = v;
9            }
10            if ((v & 1) == 1) {
11                hasOdd = true;
12            }
13        }
14        if ((mn & 1) == 1) {
15            return true;
16        }
17        return !hasOdd;
18    }
19}