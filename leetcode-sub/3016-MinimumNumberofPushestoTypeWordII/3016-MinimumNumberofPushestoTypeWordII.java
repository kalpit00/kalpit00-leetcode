// Last updated: 7/30/2026, 10:08:20 PM
1class Solution {
2    public int minimumPushes(String word) {
3        int[] map = new int[26];
4        for (char c : word.toCharArray()) {
5            map[c - 'a']++;
6        }
7        Arrays.sort(map);
8        int count = 1, sum = 0, j = 0;
9        for (int i = map.length - 1; i >= 0; i--) {
10            if (map[i] == 0) break;
11            sum += map[i] * count;
12            j++;
13            count += j % 8 == 0 ? 1 : 0;
14        }
15        return sum;
16    }
17}