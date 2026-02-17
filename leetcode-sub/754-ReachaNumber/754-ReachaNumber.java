// Last updated: 2/17/2026, 3:20:54 AM
1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        int count = 0, n = costs.length;
4        costs = sortArray(costs);
5        for (int i = 0; i < n; i++) {
6            if (coins - costs[i] < 0) break;
7            coins -= costs[i];
8            count++;
9        }
10        return count;
11    }
12    public int[] sortArray(int[] nums) {
13        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
14        for (int num : nums) {
15            min = Math.min(min, num);
16            max = Math.max(max, num);
17        }
18        int size = max - min + 1;
19        int[] buckets = new int[size];
20        for (int num : nums) {
21            buckets[num - min]++;
22        }
23        int index = 0;
24        for (int i = 0; i < size; i++) {
25            while (buckets[i] > 0) {
26                nums[index++] = i + min;
27                buckets[i]--;
28            }
29        }
30        return nums;
31    }
32
33}