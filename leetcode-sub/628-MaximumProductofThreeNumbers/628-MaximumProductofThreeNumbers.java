// Last updated: 7/25/2026, 9:26:44 PM
1class Solution {
2    public int maximumProduct(int[] nums) {
3        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
4        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
5        for (int num : nums) {
6            if (num < min1) {
7                min2 = min1;
8                min1 = num;
9            } else if (num < min2) {
10                min2 = num;
11            }
12            if (num > max1) {
13                max3 = max2;
14                max2 = max1;
15                max1 = num;
16            } else if (num > max2) {
17                max3 = max2;
18                max2 = num;
19            } else if (num > max3) {
20                max3 = num;
21            }
22        }
23        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
24    }
25}