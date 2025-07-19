// Last updated: 7/19/2025, 5:01:46 PM
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = n, right = -1;
        Stack<Integer> stack = new Stack<>();
        int[] NSE = new int[n], PGE = new int[n];
        Arrays.fill(NSE, n);
        Arrays.fill(PGE, -1);
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                NSE[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                PGE[i] = stack.peek();
            }
            stack.push(i);
        } // find leftmost and rightmost element which has a PGE or NSE
        for (int i = 0; i < n; i++) {
            if (NSE[i] != n || PGE[i] != -1) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            } // just take the indexes : i
        } // subarr : [left .. right] is unsorted! its length = r - l + 1
        return left < right ? right - left + 1 : 0;
    }
}
