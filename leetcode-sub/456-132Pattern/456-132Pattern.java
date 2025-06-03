// Last updated: 6/2/2025, 10:50:14 PM
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, top = -1;
        if (n < 3) return false;
        int[][] stack = new int[n][2]; // <i, pre[i]>
        int[] PGE = new int[n];
        // Arrays.fill(PGE, -1);
        for (int k = 0; k < n; k++) { // strict PGE! so unstrict in while loop
            while (top != -1 && nums[stack[top][0]] <= nums[k]) {
                // int t = stack[top][0];
                // NGE[t] = k;
                top--; // its redundant, we don't need NGE[] nor PGE[]
            }
            if (top != -1) {
                int j = stack[top][0]; // j = 3, k = 2, 32 found
                PGE[k] = j; // now at stack top 'j', check prefix i : [0 .. j]
                if (stack[top][1] < nums[k]) {
                    return true;
                } // nums[i] < nums[k] found via pre, so 132 formed
            }
            stack[++top][0] = k;
            stack[top][1] = min;
            min = Math.min(min, nums[k]);
        }
        return false;
    }
}
