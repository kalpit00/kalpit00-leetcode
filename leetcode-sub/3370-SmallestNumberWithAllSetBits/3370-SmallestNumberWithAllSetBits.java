// Last updated: 12/26/2025, 7:17:35 AM
import java.util.*;

class Solution {

    int[] bit;
    int nVal;

   
    private void updatee(int i, int v) {
        while (i <= nVal) {
            bit[i] += v;
            i += (i & -i);
        }
    }

    
    private int Query(int i) {
        int s = 0;
        while (i > 0) {
            s += bit[i];
            i -= (i & -i);
        }
        return s;
    }

    public long minInversionCount(int[] nums, int k) {

        
        int n = nums.length;
        int[] t = Arrays.copyOf(nums, n);
        Arrays.sort(t);

        int m = 1;
        for (int i = 1; i < n; i++) {
            if (t[i] != t[m - 1]) {
                t[m++] = t[i];
            }
        }

        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.binarySearch(t, 0, m, nums[i]) + 1;
        }

        nVal = m;
        bit = new int[nVal + 5];

        long c = 0, minVal;

       
        for (int i = 0; i < k; i++) {
            c += i - Query(nums[i]);
            updatee(nums[i], 1);
        }

        minVal = c;

       
        for (int i = k; i < n; i++) {

            
            int old = nums[i - k];
            updatee(old, -1);
            c -= Query(old - 1);

            
            c += (k - 1) - Query(nums[i]);
            updatee(nums[i], 1);

            minVal = Math.min(minVal, c);
        }

        return minVal;
    }
}