// Last updated: 9/10/2025, 8:04:35 PM
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        solve(0, n, nums, set, list);
        return new ArrayList<>(set);
    }
    private void solve(int i, int n, int[] nums,
    Set<List<Integer>> set, List<Integer> list) {
        if (i >= n) {
            set.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        solve(i + 1, n, nums, set, list);
        list.remove(list.size() - 1);
        solve(i + 1, n, nums, set, list);
    }
}