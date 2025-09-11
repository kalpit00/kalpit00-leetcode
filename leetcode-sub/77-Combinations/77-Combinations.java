// Last updated: 9/10/2025, 11:09:16 PM
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        solve(0, n, k, nums, res, list);
        return res;
    }
    private void solve(int i, int n, int k, int[] nums, 
    List<List<Integer>> res, List<Integer> list) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i >= n) {
            return;
        }
        solve(i + 1, n, k, nums, res, list); // notTake, k -> k
        list.add(nums[i]);
        solve(i + 1, n, k - 1, nums, res, list); // take, k -> k - 1
        list.remove(list.size() - 1);
    }
}