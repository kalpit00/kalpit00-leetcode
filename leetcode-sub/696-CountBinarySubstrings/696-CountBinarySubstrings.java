// Last updated: 2/18/2026, 10:17:45 PM
1class Solution {
2    public int countBinarySubstrings(String s) {
3        char[] arr = s.toCharArray();
4        int n = arr.length, sum = 0;
5        List<Integer> list = new ArrayList<>();
6        for (int i = 0; i < n; i++) {
7            int m = 1;
8            char c = arr[i];
9            while (i < n - 1 && arr[i] == arr[i + 1]) {
10                i++;
11                m++;
12            }
13            list.add(m);
14        }
15        for (int i = 1; i < list.size(); i++) {
16            sum += Math.min(list.get(i - 1), list.get(i));
17        } // sum the min of adjacent groups
18        return sum;
19    }
20}