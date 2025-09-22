// Last updated: 9/21/2025, 8:10:40 PM
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int max = 0, sum = 0;
        for (int num : nums) {
            freq[num]++;
            max = Math.max(max, freq[num]);
        }
        for (int f : freq) {
            if (f == max) {
                sum += max;
            }
        }
        return sum;
    }
}