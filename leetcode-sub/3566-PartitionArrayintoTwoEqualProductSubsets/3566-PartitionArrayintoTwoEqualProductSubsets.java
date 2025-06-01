// Last updated: 6/1/2025, 3:56:46 AM
class Solution {
    public boolean checkEqualPartitions(int[] nums, long target) {
        long product=1l;
        for(int i=0;i<nums.length;i++)
            {
                product*=nums[i];
            }
        if(target*target==product)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}