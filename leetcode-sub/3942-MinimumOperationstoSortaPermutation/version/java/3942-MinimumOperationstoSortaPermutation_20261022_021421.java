// Last updated: 10/22/2026, 2:14:21 AM
1class Solution {
2
3    public int minOperations(int[] nums) {
4        final int n = nums.length;
5        if (n == 1) {
6            return 0;
7        }
8
9        int start = 0;
10        while (nums[start] != 0) {
11            start++;
12        }
13
14        boolean asc = true;
15        boolean desc = true;
16
17        for (int i = 1; i < n; i++) {
18            final int value = nums[(start + i) % n];
19
20            if (value != i) {
21                asc = false;
22            }
23            if (value != n - i) {
24                desc = false;
25            }
26
27            if (!asc && !desc) {
28                return -1;
29            }
30        }
31
32        if (asc) {
33            return Math.min(start, n - start + 2);
34        }
35
36        return Math.min(n - start, start + 2);
37    }
38}