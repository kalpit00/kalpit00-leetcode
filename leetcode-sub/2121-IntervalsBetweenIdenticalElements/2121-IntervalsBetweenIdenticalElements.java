// Last updated: 2/19/2026, 3:20:25 AM
1class Solution {
2    public long[] getDistances(int[] nums) {
3        int n = nums.length;
4        long[] arr = new long[n];
5        Map<Integer, List<Integer>> map = new HashMap<>();
6        for (int i = 0; i < n; i++) {
7            map.putIfAbsent(nums[i], new ArrayList<>());
8            map.get(nums[i]).add(i);
9        }
10        for (int key : map.keySet()) {
11            List<Integer> group = map.get(key);
12            long[] res = getSumAbsoluteDifferences(group);
13            for (int i = 0; i < group.size(); i++) {
14                arr[group.get(i)] = res[i];
15            }
16        }
17        return arr;
18    }
19
20    private long[] getSumAbsoluteDifferences(List<Integer> nums) {
21        int n = nums.size();
22        long[] pre = new long[n], suf = new long[n], res = new long[n];
23        for (int i = 1; i < n; i++) {
24            pre[i] = pre[i - 1] + nums.get(i - 1);
25        }
26        for (int i = n - 2; i >= 0; i--) {
27            suf[i] = suf[i + 1] + nums.get(i + 1);
28        }
29        for (int i = 0; i < n; i++) {
30            long val = nums.get(i);
31            res[i] = (suf[i] - (n - i - 1) * val) - 
32            (pre[i] - i * val);
33        }
34        return res;
35    }
36}