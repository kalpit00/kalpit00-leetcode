// Last updated: 7/30/2025, 9:13:32 PM
class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> res = new HashSet<>(), prev = new HashSet<>();
        for (int num : nums) {
            Set<Integer> curr = new HashSet<>();
            curr.add(num);
            for (int old : prev) {
                curr.add(old | num);
            }
            res.addAll(curr);
            prev = curr;
        }
        return res.size();
    }
}