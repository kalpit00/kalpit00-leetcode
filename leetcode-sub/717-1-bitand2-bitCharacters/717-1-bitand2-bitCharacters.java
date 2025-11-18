// Last updated: 11/17/2025, 11:48:33 PM
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;
        for (i = 0; i < n - 1; i++) {
            i += bits[i] == 1 ? 1 : 0; // for every 1, move to next
        }
        return i == n - 1;
    }
}