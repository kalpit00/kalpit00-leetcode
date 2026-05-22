// Last updated: 5/22/2026, 8:41:05 AM
1public class Solution {
2    int mod = 1000000007;
3    public int rangeSum(int[] nums, int n, int left, int right) {
4        int rSum = lowerbound(nums, n, right), 
5        lSum = lowerbound(nums, n, left - 1);
6        long[] r = countsubarraysumlessequal(nums, n, rSum), 
7        l = countsubarraysumlessequal(nums, n, lSum);
8 // duplicates : [.. left-1 <- l[0] ... right -> r[0] ...]        
9        long pre_j = r[1] - rSum * (r[0] - right);
10        long pre_i = l[1] - lSum * (l[0] - (left - 1));
11        long res = (pre_j - pre_i) % mod;
12        return (int) ((res + mod) % mod);
13    }
14
15    private int lowerbound(int[] nums, int n, int k) {
16        int start = 0, end = 0, ans = 0;
17        for (int num : nums) {
18            start = Math.min(start, num);
19            end += num;
20        } // binary search over [min(nums[i]) .. sum(nums[i])] : log(100^2) = 4
21        while (start <= end) {
22            int mid = start + (end - start) / 2;
23            if (countsubarraysumlessequal(nums, n, mid)[0] >= k) {
24                ans = mid;
25                end = mid - 1;
26            } // O(N) sliding window helper : 10^3, final TC = 4 * 10^3
27            else {
28                start = mid + 1;
29            }
30        }
31        return ans; // kth smallest subarray sum!
32    }
33
34    private long[] countsubarraysumlessequal(int[] nums, int n, int target) {
35        long total = 0, sum = 0, windowSum = 0;
36        int count = 0, left = 0, right = 0;
37        while (right < n) {
38            sum += nums[right];
39            windowSum += nums[right++] * (right - left);
40            while (sum > target) {
41                windowSum -= sum;
42                sum -= nums[left];
43                left++;
44            } // count subarrays with sum <= target
45            count += right - left;
46            total += windowSum;
47        } // total = total sum of all subarrays with sum <= target
48        return new long[]{count, total};
49    }
50}
51