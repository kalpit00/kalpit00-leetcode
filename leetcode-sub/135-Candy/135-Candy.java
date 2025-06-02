// Last updated: 6/1/2025, 8:06:42 PM
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int candies[] = new int[n];        
        Arrays.fill(candies, 1); // Give each child 1 candy minimum
// Scan left to right, right higher rated child gets 1 more candy than left lower rated child            
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = Math.max(candies[i], candies[i - 1] + 1);
            }
        }
// Scan right to left, left higher rated child gets 1 more candy than right lower rated child        
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
            }
        }
        int sum = 0;        
        for (int candy : candies) {
            sum += candy;        
        } 
        return sum;
    }
}