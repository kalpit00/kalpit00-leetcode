// Last updated: 6/22/2026, 4:25:08 AM
1class Solution {
2    public int maxNumberOfBalloons(String text) {
3        int min = 0;
4        int a = 0, b = 0, o = 0, l = 0, n = 0;
5        for (char c : text.toCharArray()) {
6            if (c == 'a') a++;
7            else if (c == 'b') b++;
8            else if (c == 'o') o++;
9            else if (c == 'l') l++;
10            else if (c == 'n') n++;
11        }
12        return IntStream.of(a, b, n, l/2, o/2).min().getAsInt();
13    }
14}