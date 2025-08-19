// Last updated: 8/19/2025, 6:49:04 PM
import java.math.*;
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        BigInteger dp = BigInteger.ONE;
        Set<Integer> set = new TreeSet<Integer>();
        for (int reward : rewardValues) {
            set.add(reward);
        }
        for (int i : set) {
            BigInteger mask = BigInteger.ONE.shiftLeft(i).subtract(BigInteger.ONE); // (1 << i) - 1
            BigInteger prevSum = dp.and(mask); // dp & (mask)
            dp = dp.or(prevSum.shiftLeft(i)); // dp |= (mask << i)
        }
        return dp.bitLength() - 1;
    }
}