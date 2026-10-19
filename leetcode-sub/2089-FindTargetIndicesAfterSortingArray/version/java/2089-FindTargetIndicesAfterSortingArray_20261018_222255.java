// Last updated: 10/18/2026, 10:22:55 PM
1class Solution {
2    public List<Integer> targetIndices(int[] nums, int target) {
3        int cnt1 = 0, cnt2 = 0;
4        for (int num : nums) {
5            if (num < target) {
6                cnt1++;
7            } 
8            else if (num == target) {
9                cnt2++;
10            }
11        }
12        List<Integer> res = new ArrayList<>();
13        for (int i = cnt1; i < cnt1 + cnt2; i++) {
14            res.add(i);
15        }
16        return res;
17    }
18}