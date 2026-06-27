// Last updated: 6/26/2026, 8:31:06 PM
1class Solution {
2
3    public int maximumLength(int[] nums) {
4        Map<Long, Integer> cnt = new HashMap<>();
5        for (int num : nums) {
6            cnt.merge((long) num, 1, Integer::sum);
7        }
8
9        int oneCnt = cnt.getOrDefault(1L, 0);
10        // ans is at least the number of occurrences of 1, rounded down to an odd number
11        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;
12
13        cnt.remove(1L);
14
15        for (long num : cnt.keySet()) {
16            int res = 0;
17            long x = num;
18
19            while (cnt.containsKey(x) && cnt.get(x) > 1) {
20                res += 2;
21                x *= x;
22            }
23
24            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
25        }
26
27        return ans;
28    }
29}