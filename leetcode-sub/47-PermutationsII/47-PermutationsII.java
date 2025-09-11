// Last updated: 9/10/2025, 11:18:32 PM
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, n, list, set, nums);
        return new ArrayList<>(set);
    }
    
    public void backtrack(int mask, int n,
    List<Integer> list, Set<List<Integer>> set, int[] nums) {
        if (list.size() >= n) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) != 0) continue;
            list.add(nums[i]);
            backtrack(mask | (1 << i), n, list, set, nums);
            list.remove(list.size() - 1);
        }
    }
}