// Last updated: 10/18/2026, 11:28:56 PM
1class Solution {
2    public List<List<Integer>> findDisappearedNumbers(int[] arr, int lower, int upper) {
3        int[] nums = new int[upper + 1];
4        for (int num : arr) {
5            if (num > upper || num < lower) continue;
6            nums[num] = 1;
7        }
8        List<List<Integer>> res = new ArrayList<>();
9        for (int i = lower; i <= upper; i++) {
10            if (nums[i] == 1) continue;
11            int m = i; // m = streak start
12            List<Integer> range = new ArrayList<>();
13            range.add(m);
14            while (i < upper && nums[i + 1] == 0) {
15                m++;
16                i++;
17            }
18            range.add(m);
19            res.add(range);
20        }
21        return res;
22    }
23}