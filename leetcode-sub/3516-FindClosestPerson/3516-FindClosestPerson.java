// Last updated: 9/3/2025, 8:09:03 PM
class Solution {
    public int findClosest(int x, int y, int z) {
        return Math.abs(x - z) < Math.abs(y - z) ? 
        1 : Math.abs(x - z) > Math.abs(y - z) ? 2 : 0;
    }
}