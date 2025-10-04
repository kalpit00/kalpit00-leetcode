// Last updated: 10/4/2025, 6:10:10 AM
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int sum1 = coordinate1.charAt(0) + coordinate1.charAt(1);
        int sum2 = coordinate2.charAt(0) + coordinate2.charAt(1);
        return (sum1 % 2) == (sum2 % 2);
    }
}