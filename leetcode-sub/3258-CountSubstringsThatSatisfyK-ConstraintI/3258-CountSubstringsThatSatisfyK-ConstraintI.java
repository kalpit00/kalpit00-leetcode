// Last updated: 10/4/2025, 6:13:10 AM
class Solution {
    public int minChanges(int n, int k) {
        if ((n & k) != k) {
            return -1;
        }

        int diff = n ^ k;
        int changes = 0;
        
        while (diff > 0) {
            if ((diff & 1) == 1) {
                changes++;
            }
            diff >>= 1;
        }
        
        return changes;
    }
}