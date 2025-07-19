// Last updated: 7/19/2025, 5:16:27 PM
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, left = n, right = -1, top = -1;
        int[] NSE = new int[n], PGE = new int[n], stack = new int[n];
        Arrays.fill(NSE, n);
        Arrays.fill(PGE, -1);
        for (int i = 0; i < n; i++) {
            while (top >= 0 && nums[stack[top]] > nums[i]) {
                NSE[stack[top--]] = i;
            }
            stack[++top] = i;
        }
        top = -1;
        for (int i = 0; i < n; i++) {
            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }
            if (top >= 0) {
                PGE[i] = stack[top];
            }
            stack[++top] = i;
        } // find first and last element which has a PGE or NSE
        for (int i = 0; i < n; i++) {
            if (NSE[i] != n || PGE[i] != -1) {
                left = i;
                break;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (NSE[i] != n || PGE[i] != -1) {
                right = i;
                break;
            }
        } // subarr : [left .. right] is unsorted! its length = r - l + 1
        return left < right ? right - left + 1 : 0;
    }
}
