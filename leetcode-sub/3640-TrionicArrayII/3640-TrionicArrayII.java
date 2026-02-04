// Last updated: 2/3/2026, 10:18:53 PM
1class Solution {
2
3    public long maxSumTrionic(int[] nums) {
4        int n = nums.length;
5        long ans = Long.MIN_VALUE;
6
7        for (int i = 0; i < n; i++) {
8            int j = i + 1;
9            long res = 0;
10
11            // first segment: increasing segment
12            while (j < n && nums[j - 1] < nums[j]) {
13                j++;
14            }
15            int p = j - 1;
16
17            if (p == i) {
18                continue;
19            }
20
21            // second segment: decreasing segment
22            res += nums[p] + nums[p - 1];
23            while (j < n && nums[j - 1] > nums[j]) {
24                res += nums[j];
25                j++;
26            }
27            int q = j - 1;
28
29            if (q == p || q == n - 1 || (j < n && nums[j] <= nums[q])) {
30                i = q;
31                continue;
32            }
33
34            // third segment: increasing segment
35            res += nums[q + 1];
36
37            // find the maximum sum of the third segment
38            long maxSum = 0;
39            long sum = 0;
40            for (int k = q + 2; k < n && nums[k] > nums[k - 1]; k++) {
41                sum += nums[k];
42                maxSum = Math.max(maxSum, sum);
43            }
44            res += maxSum;
45
46            // find the maximum sum of the first segment
47            maxSum = 0;
48            sum = 0;
49            for (int k = p - 2; k >= i; k--) {
50                sum += nums[k];
51                maxSum = Math.max(maxSum, sum);
52            }
53            res += maxSum;
54
55            // update answer
56            ans = Math.max(ans, res);
57            i = q - 1;
58        }
59
60        return ans;
61    }
62}