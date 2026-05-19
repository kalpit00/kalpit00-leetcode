// Last updated: 5/18/2026, 10:04:12 PM
1class Solution {
2    public int getCommon(int[] nums1, int[] nums2) {
3        int m = nums1.length, n = nums2.length, i = 0, j = 0;
4        if (nums1[m - 1] < nums2[0] || nums2[n - 1] < nums1[0]) {
5            return -1;
6        }        
7        while (i < m && j < n) {
8            if (nums1[i] == nums2[j]) {
9                return nums1[i];
10            }
11            if (nums1[i] < nums2[j]) {
12                i++;
13            }
14            else {
15                j++;
16            }
17        }
18        return -1;
19    }
20}