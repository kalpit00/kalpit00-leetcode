// Last updated: 6/29/2026, 11:25:01 PM
1class Solution {
2    public int numberOfSubstrings(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length, left = 0, right = 0, count = 0;
5        int[] map = new int[3];
6        while (right < n) {
7            map[arr[right++] - 'a']++;
8            while (left < n && map[0] > 0 && map[1] > 0 && map[2] > 0) {
9                map[arr[left++] - 'a']--;
10            }
11            count += left;
12        }
13        return count;
14    }
15}