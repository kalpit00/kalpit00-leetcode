// Last updated: 1/23/2026, 11:29:05 PM
1class Solution {
2    public int minPairSum(int[] nums) {
3        int n = nums.length, sum = 0;
4        nums = sortArray(nums);
5        for (int i = 0; i < n / 2; i++) {
6            sum = Math.max(sum, nums[i] + nums[n - i - 1]);
7        }
8        return sum;
9    }
10    public int[] sortArray(int[] nums) {
11        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
12        for (int num : nums) {
13            min = Math.min(min, num);
14            max = Math.max(max, num);
15        }
16        int size = max - min + 1;
17        int[] buckets = new int[size];
18        for (int num : nums) {
19            buckets[num - min]++;
20        }
21        int index = 0;
22        for (int i = 0; i < size; i++) {
23            for (int j = 0; j < buckets[i]; j++) {
24                nums[index++] = i + min;
25            }
26        }
27        return nums;
28    }
29}