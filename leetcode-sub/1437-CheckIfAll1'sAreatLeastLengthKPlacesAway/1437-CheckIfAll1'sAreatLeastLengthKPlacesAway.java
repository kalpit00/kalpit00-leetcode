// Last updated: 11/16/2025, 11:05:59 PM
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                list.add(i);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) <= k) {
                return false;
            }
        }
        return true;
    }
}