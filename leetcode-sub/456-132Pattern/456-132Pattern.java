// Last updated: 6/2/2025, 11:02:12 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, top = -1;
        if (n < 3) return false;
        int[] stack = new int[n], pre = new int[n], PGE = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.min(pre[i - 1], nums[i]);
        }
        // Arrays.fill(PGE, -1);
        for (int k = 0; k < n; k++) { // strict PGE! so unstrict in while loop
            while (top != -1 && nums[stack[top]] <= nums[k]) {
                // int t = stack[top];
                // NGE[t] = k;
                top--; // its redundant, we don't need NGE[] nor PGE[]
            }
            if (top != -1) {
                int j = stack[top]; // j = 3, k = 2, 32 found
                PGE[k] = j; // now at stack top 'j', check prefix i : [0 .. j]
                if (pre[j] < nums[k]) {
                    return true; // pre[j] == nums[i]!
                } // nums[i] < nums[k], so 132 formed
            }
            stack[++top] = k;
        }
        return false;
    }
}
