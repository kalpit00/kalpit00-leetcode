// Last updated: 11/30/2025, 8:31:11 PM
1class Solution {
2    public long maxRunTime(int n, int[] nums) {
3        long sum = 0;
4        for (int num : nums) {
5            sum += num;
6        }
7        long start = 1, end = sum / n, ans = -1;
8        while (start <= end) {
9            long mid = start + (end - start) / 2;
10            if (helper(nums, mid, n)) {
11                ans = mid;
12                start = mid + 1;
13            }
14            else {
15                end = mid - 1;
16            }
17        }
18        return ans;
19    }
20    private boolean helper(int[] nums, long mid, int n) {
21        long sum = 0;
22        for (int num : nums) {
23            sum += Math.min(num, mid);
24            if (sum >= (long) (n * mid)) {
25                return true;
26            }
27        }
28        return sum >= (long) (n * mid);
29    }
30}