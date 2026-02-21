// Last updated: 2/21/2026, 2:58:00 PM
1class Solution {
2    public List<Integer> minSubsequence(int[] nums) {
3        Arrays.sort(nums);
4        int sum = 0;
5        for (int num : nums) {
6            sum+= num;
7        }
8        int currSum = 0;
9        List<Integer> res = new ArrayList();
10        for (int i = nums.length - 1; i >= 0; i--) {
11            currSum+= nums[i];
12            res.add(nums[i]);
13            if (currSum > sum - currSum) {
14                return res;
15            }
16        }
17        return new ArrayList<>();
18    }
19}