// Last updated: 3/25/2026, 6:06:25 PM
class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long totalScore = 0;
        long currentMax = 0;
        
        // We iterate through all elements except the last one
        for (int i = 0; i < nums.size() - 1; i++) {
            // Update the best multiplier we've seen so far
            currentMax = Math.max(currentMax, (long)nums.get(i));
            
            // Add the current best multiplier to the score for this "step"
            totalScore += currentMax;
        }
        
        return totalScore;
    }
}