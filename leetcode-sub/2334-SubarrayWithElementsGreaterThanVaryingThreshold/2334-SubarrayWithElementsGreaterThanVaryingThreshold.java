// Last updated: 6/2/2025, 1:01:50 PM
class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length, top = -1;
        int[] stack = new int[n], NSE = new int[n], PSE = new int[n];
        Arrays.fill(PSE, -1);
        Arrays.fill(NSE, n);
        for (int i = 0; i < n; i++) {
            while (top != -1 && nums[stack[top]] > nums[i]) {
                int t = stack[top--];
                NSE[t] = i;
            }
            if (top != -1) {
                PSE[i] = stack[top];
            }
            stack[++top] = i;
        }
        for (int i = 0; i < n; i++) { // (NSE[i] - 1) - (PSE[i] + 1) + 1
            int len = NSE[i] - PSE[i] - 1; // [pse + 1 ... i ... nse - 1]
            if (nums[i] > threshold / len) {
                return len;
            }
        }
        return -1;
    }
}