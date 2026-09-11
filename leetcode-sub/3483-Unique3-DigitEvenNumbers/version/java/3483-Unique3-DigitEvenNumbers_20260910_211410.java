// Last updated: 9/10/2026, 9:14:10 PM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        int[] map = new int[10];
4        boolean flag = false;
5        for (int num : digits) {
6            map[num]++;
7            flag = num % 2 == 0 ? true : flag;
8        }
9        if (!flag) {
10            return 0; // no even digits to put on last place
11        }
12        int count = 0;
13        for (int i = 1; i < 10; i++) {
14            if (map[i] == 0) continue;
15            map[i]--;
16            for (int j = 0; j < 10; j++) {
17                if (map[j] == 0) continue;
18                map[j]--;
19                for (int k = 0; k < 10; k += 2) {
20                    if (map[k] == 0) continue;
21                    count++;
22                }
23                map[j]++;
24            }
25            map[i]++;
26        }
27        return count;
28    }
29}