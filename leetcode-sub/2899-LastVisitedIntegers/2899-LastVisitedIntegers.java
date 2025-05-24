// Last updated: 5/24/2025, 12:17:40 AM
class Solution {
    public List<Integer> lastVisitedIntegers(int[] nums) {
        List<Integer> stack = new ArrayList<>(), res = new ArrayList<>();
        int top = -1;
        for (int num : nums) {
            if (num == -1) {
                if (top == -1) {
                    res.add(-1);
                }
                else {
                    res.add(stack.get(top));
                    top--;
                }
            }
            else {
                stack.add(num);
                top = stack.size() - 1;
            }
        }
        return res;
    }
}