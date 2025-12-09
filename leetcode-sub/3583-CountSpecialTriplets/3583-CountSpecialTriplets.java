// Last updated: 12/8/2025, 10:29:34 PM
1class Solution {
2    public int specialTriplets(int[] nums) {
3        int n = nums.length, mod = 1000000007;
4        int[] pre = new int[n], suf = new int[n], map = new int[200002];
5        long count = 0;
6        map[nums[0]]++;
7        for (int i = 1; i < n; i++) {
8            pre[i] = map[nums[i] * 2];
9            map[nums[i]]++;
10        }
11        Arrays.fill(map, 0);
12        map[nums[n - 1]]++;
13        for (int i = n - 2; i >= 0; i--) {
14            suf[i] = map[nums[i] * 2];
15            map[nums[i]]++;
16        }
17        for (int i = 1; i < n - 1; i++) {
18            count += 1L * pre[i] * suf[i];
19            count %= mod;
20        }
21        return (int) count;
22    }
23}