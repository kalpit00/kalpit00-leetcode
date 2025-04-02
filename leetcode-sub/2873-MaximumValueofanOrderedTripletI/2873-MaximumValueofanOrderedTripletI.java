// Last updated: 4/2/2025, 5:11:13 AM
class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num - 2 * diff)) {
                count++;
            }
            set.add(num);
        }
        return count;
    }
}