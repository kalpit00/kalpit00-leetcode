// Last updated: 7/30/2025, 6:03:42 PM
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        cycleSort(nums);
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
    private void cycleSort(int[] nums) {
        int n = nums.length, i = 0;
        while (i < n) { // no need to validate index as nums[i] : [1, n]
            if (nums[i] == nums[nums[i] - 1]) {
                i++;
            } // repeatedly check if nums[i] is on the index : nums[i] - 1
            else {
                swap(nums, i, nums[i] - 1);
            } // if not, swap to place [1] on idx 0, [2] on idx 1, and so on ..
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}