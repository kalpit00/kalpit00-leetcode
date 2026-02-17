// Last updated: 2/17/2026, 3:31:47 AM
1class Solution {
2    public String minWindow(String s, String t) {
3        int[] map = new int[128];
4        char[] arr = s.toCharArray();
5        for (char c : t.toCharArray()) {
6            map[c]++;
7        }
8        int left = 0, right = 0, min = Integer.MAX_VALUE, i = 0, 
9        count = t.length(), n = arr.length;
10        while (right < n) {
11            if (map[arr[right]] > 0) {
12                count--;
13            }
14            map[arr[right]]--;
15            right++;
16            while (count == 0) {
17                // System.out.println(s.substring(left, right));
18                if (min > right - left) {
19                    min = right - left;
20                    i = left;
21                }
22                map[arr[left]]++;
23                if (map[arr[left]] > 0) {
24                    count++;
25                }
26                left++;
27            }
28        }
29        return min == Integer.MAX_VALUE ? "" : s.substring(i, i + min);
30    }
31}