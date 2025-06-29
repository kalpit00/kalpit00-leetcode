// Last updated: 6/28/2025, 8:20:40 PM
class Solution {
    int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        int n = nums.length, count = 0, left = 0, right = n - 1;
        Arrays.sort(nums);
        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        } // pow[i] =  2^(i) with MOD!
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                count += power[right - left]; // 2^(r - l) overflows integer 
                count %= mod;
                left++;
            }
            else {
                right--;
            }
        }
        return count;
    }
}