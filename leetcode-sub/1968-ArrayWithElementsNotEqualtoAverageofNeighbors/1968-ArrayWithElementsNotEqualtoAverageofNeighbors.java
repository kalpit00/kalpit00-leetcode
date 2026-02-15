// Last updated: 2/14/2026, 9:20:39 PM
class Solution {
    public int[] rearrangeArray(int[] nums) {
        for(var i = 1; i < nums.length; i++){
            if(i % 2 == 0 && nums[i] < nums[i - 1]){
                swap(i, i - 1, nums);
            }
            if(i % 2 == 1 && nums[i] > nums[i - 1]){
                swap(i, i - 1, nums);
            }
        }
        return nums;
    }

    void swap(int i, int j, int[] nums){
        var t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}