// Last updated: 7/30/2025, 9:11:58 PM
class Solution {
    public int subarrayBitwiseORs(int[] nums) {
        Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2;
        for (Integer i : nums) {
            cur2 = new HashSet<>();
            cur2.add(i);
            for (Integer j : cur) {
                cur2.add(i | j);
            }
            res.addAll(cur = cur2);
        }
        return res.size();
    }
}