// Last updated: 10/4/2025, 6:19:08 AM
import java.util.List;

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        
        // The second subarray starts at index b = a + k.
        // The first subarray ends at a + k - 1.
        // The combined segment is of length 2*k, running from index a to a + 2*k - 1.
        // We only need to iterate 'a' up to the point where a + 2*k is within the bounds.
        if (n < 2 * k) {
            return false;
        }

        // Iterate through all possible starting indices 'a' for the first subarray.
        // The loop must stop when there is no room for two adjacent k-length subarrays.
        // Max index for 'a' is n - 2*k.
        for (int a = 0; a <= n - 2 * k; a++) {
            // Check the first subarray: nums[a...a + k - 1]
            boolean firstIncreasing = isStrictlyIncreasing(nums, a, a + k - 1);
            
            if (firstIncreasing) {
                // If the first is increasing, check the second adjacent subarray.
                // The second subarray starts at b = a + k.
                int b = a + k;
                
                // Check the second subarray: nums[b...b + k - 1]
                boolean secondIncreasing = isStrictlyIncreasing(nums, b, b + k - 1);
                
                if (secondIncreasing) {
                    return true;
                }
            }
        }
        
        return false;
    }

    // Helper method to check if a subarray is strictly increasing.
    private boolean isStrictlyIncreasing(List<Integer> nums, int start, int end) {
        // The subarray is defined by nums[start] up to and including nums[end].
        // We check elements from start up to (end - 1).
        for (int i = start; i < end; i++) {
            // Strictly increasing means nums[i] < nums[i + 1]
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}