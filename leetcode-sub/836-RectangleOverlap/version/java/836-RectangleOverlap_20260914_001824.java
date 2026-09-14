// Last updated: 9/14/2026, 12:18:24 AM
1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        // check if either rectangle is actually a line
4        if (rec1[0] == rec1[2] || rec1[1] == rec1[3] ||
5            rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
6            // the line cannot have positive overlap
7            return false;
8        }
9
10        return !(rec1[2] <= rec2[0] ||   // left
11                 rec1[3] <= rec2[1] ||   // bottom
12                 rec1[0] >= rec2[2] ||   // right
13                 rec1[1] >= rec2[3]);    // top
14    }
15}