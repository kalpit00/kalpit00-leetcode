// Last updated: 6/20/2025, 12:15:40 PM
import java.util.*;
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length, sum = 0;
        for (int bit = 0; bit < 32; bit++) {
            BitSet bitset = new BitSet(n);
            for (int i = 0; i < n; i++) {
                if ((nums[i] & (1 << bit)) != 0) {
                    bitset.set(i);
                }
            }
            int ones = bitset.cardinality(); // count of 1s at this bit index
            int zeros = n - ones;            // count of 0s
            sum += ones * zeros;
        }
        return sum;
    }
}
