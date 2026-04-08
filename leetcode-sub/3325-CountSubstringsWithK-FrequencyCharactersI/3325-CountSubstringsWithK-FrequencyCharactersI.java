// Last updated: 4/8/2026, 1:16:37 AM
1class Solution {
2    public int numberOfSubstrings(String str, int k) {
3        char[] s = str.toCharArray();
4        int n = s.length, left = 0, right = 0, count = 0, sum = 0;
5        int[] map = new int[26];
6        while (right < n) {
7            map[s[right] - 'a']++;
8            count += map[s[right] - 'a'] == k ? 1 : 0;
9            right++;
10            while (left < right && count >= 1) {
11                map[s[left] - 'a']--;
12                count -= map[s[left] - 'a'] == k - 1 ? 1 : 0;
13                left++;
14            }
15            sum += right - left;
16        }
17        return (n * (n + 1) / 2) - sum;
18    }
19}