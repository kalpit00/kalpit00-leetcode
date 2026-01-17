// Last updated: 1/17/2026, 3:49:18 PM
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
15        }
16        int k = list.size();
17        for (int i = 1; i < k - 1; i++) {
18            if (list.get(i)[0] == 0) continue;
19            int ans = list.get(i - 1)[1] + list.get(i + 1)[1];
20            max = Math.max(max, ans);
21        }
22        return max + count;
23    }
24}