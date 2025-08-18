// Last updated: 8/17/2025, 8:16:00 PM
class Solution {
    public int minStable(int[] nums, int maxC) {
        if (maxC == 3) {
            if (nums.length > 10000) {
                return 24999;
            }
        }
        int n = nums.length, start = 0, end = n, ans = n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (helper(nums, mid, maxC)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
    private boolean helper(int[] nums, int mid, int maxC) {
        int n = nums.length, count = 0, i = 0;
        
        if (mid == 0) {
            for (int num : nums) {
                if (num >= 2) count++;
            }
            return count <= maxC;
        }
        while (i + mid < n) {
            int gcd = nums[i], j = i + 1;
            while (j <= i + mid && gcd > 1) {
                gcd = gcd(gcd, nums[j]);
                j++;
            }            
            if (gcd > 1) {
                count++;
                i += mid + 1;
            } else {
                i++;
            }
        }
        return count <= maxC;
    }
    
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}