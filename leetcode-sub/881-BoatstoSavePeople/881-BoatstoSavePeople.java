// Last updated: 1/26/2026, 3:15:48 PM
1class Solution {
2    public int numRescueBoats(int[] people, int limit) {
3        int count = 0;
4        people = sortArray(people);
5        int left = 0, right = people.length - 1;
6        while (left <= right) {
7            left += (people[left] + people[right] <= limit) ? 1 : 0;
8            count++;
9            right--;
10        }
11        return count;
12    }
13    public int[] sortArray(int[] nums) {
14        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
15        for (int num : nums) {
16            min = Math.min(min, num);
17            max = Math.max(max, num);
18        }
19        int size = max - min + 1;
20        int[] buckets = new int[size];
21        for (int num : nums) {
22            buckets[num - min]++;
23        }
24        int index = 0;
25        for (int i = 0; i < size; i++) {
26            for (int j = 0; j < buckets[i]; j++) {
27                nums[index++] = i + min;
28            }
29        }
30        return nums;
31    }
32}