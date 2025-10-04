// Last updated: 10/4/2025, 6:20:00 AM
class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int validSelections = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // Try starting at index i with initial direction right (1)
                if (isValidStart(nums, i, 1)) {
                    validSelections++;
                }
                // Try starting at index i with initial direction left (-1)
                if (isValidStart(nums, i, -1)) {
                    validSelections++;
                }
            }
        }
        
        return validSelections;
    }

    private boolean isValidStart(int[] originalNums, int start, int initialDirection) {
        int[] nums = Arrays.copyOf(originalNums, originalNums.length);
        int n = nums.length;
        int curr = start;
        int direction = initialDirection;
        
        // Initial move after selection: curr is at a 0, so move in the chosen direction.
        curr += direction;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                // Case 1: nums[curr] == 0. Continue in the current direction.
                curr += direction;
            } else { // nums[curr] > 0
                // Case 2: nums[curr] > 0.
                
                // Decrement nums[curr] by 1.
                nums[curr]--;
                
                // Reverse the movement direction.
                direction = -direction;
                
                // Take a step in the new direction.
                curr += direction;
            }
        }
        
        // Check if all elements are now 0.
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        
        return true;
    }
}