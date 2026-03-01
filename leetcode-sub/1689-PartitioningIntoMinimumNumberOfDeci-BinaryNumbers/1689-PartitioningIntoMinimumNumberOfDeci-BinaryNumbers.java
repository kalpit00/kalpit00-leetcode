// Last updated: 2/28/2026, 7:38:51 PM
class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (char c : n.toCharArray()) {
            maxDigit = Math.max(maxDigit, c - '0');
            
            // Early stop if we reach 9 (maximum possible)
            if (maxDigit == 9) {
                return 9;
            }
        }
        
        return maxDigit;
    }
}