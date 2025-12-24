// Last updated: 12/24/2025, 4:08:26 AM
1class Solution {
2    public int minimumBoxes(int[] apple, int[] capacity) {
3        int sum = 0, n = capacity.length, j = n - 1;
4        for (int i : apple) {
5            sum += i;
6        }
7        Arrays.sort(capacity);
8        while (sum > 0) {
9            sum -= capacity[j];
10            j--;
11        }
12        return n - j - 1;
13    }
14}