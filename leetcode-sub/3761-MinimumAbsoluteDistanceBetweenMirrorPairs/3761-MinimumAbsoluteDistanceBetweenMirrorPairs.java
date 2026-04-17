// Last updated: 4/17/2026, 12:56:10 AM
1class Solution {
2    public int minMirrorPairDistance(int[] nums) {
3        int n = nums.length, min = n;
4        Map<Integer, Integer> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            int target = rev(nums[i]);
7            if (map.containsKey(nums[i])) {
8                min = Math.min(min, i - map.get(nums[i]));
9            }
10            map.put(target, i);
11        }
12        return min == n ? -1 : min;
13    }
14    private int rev(int num) {
15        List<Integer> list = new ArrayList<>();
16        while (num > 0) {
17            list.add(num % 10);
18            num /= 10;
19        }
20        int n = list.size(), i = 0, res = 0;
21        while (i < n && list.get(i) == 0) {
22            i++;
23        }
24        while (i < n) {
25            res = res * 10 + list.get(i++);
26        }
27        return res;
28    }
29}