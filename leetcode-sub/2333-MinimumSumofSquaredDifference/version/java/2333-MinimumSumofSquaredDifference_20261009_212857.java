// Last updated: 10/9/2026, 9:28:57 PM
1class Solution {
2    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
3        int n = nums1.length, k = k1 + k2, max = 0;
4        long sum = 0;
5        int[] diff = new int[n];
6        for (int i = 0; i < n; i++) {
7            diff[i] = Math.abs(nums1[i] - nums2[i]);
8            max = Math.max(max, diff[i]);
9        }
10        int[] bucket = new int[max + 1];
11        for (int i = 0; i < n; i++) {
12            bucket[diff[i]]++;
13        }
14        for (int i = max; i > 0; i--) {
15            if (bucket[i] > 0) {
16                int min = Math.min(bucket[i], k);
17                bucket[i] -= min; // lower 'i' by min, inc 'i - 1' by min
18                bucket[i - 1] += min;
19                k -= min;
20            }
21        }
22        for (int i = max; i > 0; i--) {
23            sum += (long) bucket[i] * i * i;
24        }
25        return sum;
26    }
27}