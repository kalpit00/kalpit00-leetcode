// Last updated: 12/29/2025, 1:24:58 PM
1class Solution {
2    public int beautySum(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length, sum = 0;
5        for (int i = 0; i < n; i++) {
6            int[] map = new int[26];
7            for (int j = i; j < n; j++) {
8                map[arr[j] - 'a']++;
9                int max = 0, min = n, count = 0;
10                for (int k = 0; k < 26; k++) {
11                    if (map[k] == 0) continue;
12                    count++;
13                    max = Math.max(max, map[k]);
14                    min = Math.min(min, map[k]);
15                }
16                sum += count >= 2 ? max - min : 0;
17            }
18
19        }
20        return sum;
21    }
22}