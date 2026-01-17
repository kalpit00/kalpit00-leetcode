// Last updated: 1/17/2026, 3:51:45 PM
1class Solution {
2    public int maxActiveSectionsAfterTrade(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length, count = 0, max = 0;
5        List<int[]> list = new ArrayList<>();
6        for (int i = 0; i < n; i++) {
7            int m = 1; // m = streak length
8            char c = arr[i];
9            while (i < n - 1 && arr[i] == arr[i + 1]) {
10                i++;
11                m++;
12            }
13            list.add(new int[]{c - '0', m});
14            count += c == '1' ? m : 0;
15        } // can just add streak len 'm' to count all 1s in s[]
16        for (int i = 1; i < list.size() - 1; i++) {
17            if (list.get(i)[0] == 0) continue; // skip 0-streaks
18            max = Math.max(max, list.get(i - 1)[1] + list.get(i + 1)[1]);
19        } // for 1-streaks, add sum of streak len of 0s on left and right
20        return max + count;
21    }
22}