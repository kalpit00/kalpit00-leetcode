// Last updated: 6/16/2025, 5:51:08 PM
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            while (!stack.isEmpty() && gcd(stack.peek(), curr) > 1) {
                curr = (int) lcm(stack.pop(), curr);
            }
            stack.push(curr);
        }
        return new ArrayList<>(stack);
    }
    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    private long lcm(long x, long y) {
        return Math.abs(x * y) / gcd(x, y);
    }
}
