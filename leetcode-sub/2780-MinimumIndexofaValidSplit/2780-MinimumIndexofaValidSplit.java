// Last updated: 3/27/2025, 12:28:02 PM
class Solution {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size(), max = 0, count = 0, total = 0, left = 0;
        for (int num : nums) { // Boyer Moore's Algorithm
            max = count == 0 ? num : max;
            count += max == num ? 1 : -1;
        }
        for (int num : nums) {
            total += num == max ? 1 : 0;
        }
        for (int i = 0; i < n - 1; i++) {
            left += nums.get(i) == max ? 1 : 0;
            int right = total - left;
            if (left > (i + 1) / 2 && right > (n - i - 1) / 2) {
                return i;
            }
        }
        return -1;
    }
}