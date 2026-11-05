// Last updated: 11/4/2026, 7:29:04 PM
1class Solution {
2    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
3        int count = 0;
4         for (int num : arr1) {
5             if (helper(arr2, num, d) == true) {
6                 count++;
7             }
8         }
9         return count;
10    }
11    private static boolean helper(int[] arr2 , int num , int d) {
12        for (int val : arr2) {
13            if (num <= d + val && num >= val - d) {
14                return false;
15            }
16        }
17        return true;
18    }
19}