// Last updated: 9/10/2025, 11:21:46 PM
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, n, list, res, nums);
        return res;
    }
    
    public void backtrack(int mask, int n,
    List<Integer> list, List<List<Integer>> res, int[] nums) {
        if (list.size() >= n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (((mask & (1 << i)) != 0) || (i > 0 && nums[i] == nums[i-1] &&
            (mask & (1 << (i - 1))) == 0)) continue;
            list.add(nums[i]);
            backtrack(mask | (1 << i), n, list, res, nums);
            list.remove(list.size() - 1);
        }
    }
}