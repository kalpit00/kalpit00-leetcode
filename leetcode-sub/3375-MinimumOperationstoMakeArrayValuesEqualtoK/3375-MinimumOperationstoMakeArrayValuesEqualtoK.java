// Last updated: 4/8/2025, 8:23:13 PM
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num < k) {
                return -1;
            }
            if (num > k){
                set.add(num);
            }
        }
        return set.size();
    }
}