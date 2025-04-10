// Last updated: 4/9/2025, 11:58:47 PM
class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        long sum = 0;
        for (int num: nums) {
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;        
            }            
            set.add(num);
        }
        long res = (long)(k + 1) * k / 2 - sum;
        return res;        
    }
}