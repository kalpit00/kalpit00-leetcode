// Last updated: 10/16/2025, 1:37:54 AM
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];
        int ans = 0;
        for (int num : nums) {
            freq[(num % value + value) % value]++;
        }
        for (int i = 0; i < value; i++) {
            if (freq[i] < freq[ans]) {
                ans = i;
            }
        }
        return value * freq[ans] + ans;
    }
}