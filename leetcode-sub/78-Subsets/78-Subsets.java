// Last updated: 9/10/2025, 8:02:24 PM
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0, n, nums, res, list);
        return res;
    }
    private void solve(int i, int n, int[] nums,
    List<List<Integer>> res, List<Integer> list) {
        if (i >= n) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(i + 1, n, nums, res, list);
        list.remove(list.size() - 1);
        solve(i + 1, n, nums, res, list);
    }
}