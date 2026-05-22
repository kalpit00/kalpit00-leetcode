// Last updated: 5/22/2026, 9:21:51 AM
1class Solution {
2    public int smallestDistancePair(int[] nums, int k) {
3        Arrays.sort(nums);
4        int n = nums.length, start = 0, end = nums[n - 1] - nums[0], ans = -1;
5        while (start <= end) {
6            int mid = start + (end - start) / 2;
7            if (slidingWindow(nums, mid) >= k) {
8                ans = mid;
9                end = mid - 1;
10            } else {
11                start = mid + 1;
12            }
13        }
14        return ans;
15    }
16
17    private int slidingWindow(int[] nums, int max) {
18        int count = 0, left = 0;
19        for (int right = 0; right < nums.length; right++) {
20            while (nums[right] - nums[left] > max) {
21                left++;
22            }
23            count += right - left;
24        }
25        return count;
26    }
27}
28