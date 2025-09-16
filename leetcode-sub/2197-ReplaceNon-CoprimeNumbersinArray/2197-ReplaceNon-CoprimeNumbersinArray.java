// Last updated: 9/16/2025, 3:05:31 AM
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n = nums.length, top = 0;
        int[] stack = new int[n];
        stack[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            while (top > -1 && gcd(stack[top], curr) > 1) {
                curr = (int) lcm(stack[top--], curr);
            }
            stack[++top] = curr;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= top; i++) {
            res.add(stack[i]);
        }
        return res;
    }
    private long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    private long lcm(long x, long y) {
        return x * y / gcd(x, y);
    }
}
