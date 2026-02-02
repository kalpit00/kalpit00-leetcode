// Last updated: 2/1/2026, 9:48:33 PM
1class Solution {
2    public long minimumCost(int[] nums, int k, int dist) {
3        int n = nums.length;
4        long min = Long.MAX_VALUE, sum = 0;
5        TreeSet<Integer> maxHeap = new TreeSet<>((a, b) -> 
6            nums[a] == nums[b] ? b - a : nums[b] - nums[a]);
7        TreeSet<Integer> minHeap = new TreeSet<>((a, b) -> 
8            nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
9        for (int i = 1; i < Math.min(1 + dist, n); i++) {
10            minHeap.add(i);
11        }
12        for (int i = 1; i < n; i++) {
13            if (maxHeap.contains(i)) {
14                sum -= nums[i];
15                maxHeap.remove(i);
16            } else {
17                minHeap.remove(i);
18            }
19            if (i + dist < n) {
20                minHeap.add(i + dist);
21            }
22            while (maxHeap.size() < k - 2 && !minHeap.isEmpty()) {
23                int val = minHeap.first();
24                minHeap.remove(val);
25                maxHeap.add(val);
26                sum += nums[val];
27            }
28            while (!maxHeap.isEmpty() && !minHeap.isEmpty() && 
29                   nums[maxHeap.first()] > nums[minHeap.first()]) {
30                int temp = maxHeap.first();
31                maxHeap.remove(temp);
32                sum -= nums[temp];
33                int temp1 = minHeap.first();
34                minHeap.remove(temp1);
35                sum += nums[temp1];
36                maxHeap.add(temp1);
37                minHeap.add(temp);
38            }
39            if (maxHeap.size() == k - 2) {
40                min = Math.min(min, nums[0] + nums[i] + sum);
41            }
42        }
43        return min;
44    }
45}