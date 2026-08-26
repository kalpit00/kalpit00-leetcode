// Last updated: 8/25/2026, 8:55:07 PM
1class Solution {
2    public String shortestBeautifulSubstring(String s, int k) {
3        int n = s.length();
4        int onesCount = 0, left = 0;
5        String res = "";
6
7        for (int right = 0; right < n; right++) {
8            if (s.charAt(right) == '1') onesCount++;
9
10            while (onesCount > k) {
11                if (s.charAt(left) == '1') onesCount--;
12                left++;
13            }
14
15            if (onesCount == k) {
16                while (s.charAt(left) == '0') left++;
17                String candidate = s.substring(left, right + 1);
18                if (res.isEmpty() 
19                    || candidate.length() < res.length() 
20                    || (candidate.length() == res.length() && candidate.compareTo(res) < 0)) {
21                    res = candidate;
22                }
23            }
24        }
25        return res;
26    }
27}