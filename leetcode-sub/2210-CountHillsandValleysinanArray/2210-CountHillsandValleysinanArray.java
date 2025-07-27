// Last updated: 7/26/2025, 9:20:52 PM
class Solution {
    public int countHillValley(int[] nums) {
        int n = nums.length, count = 0;
        List<Integer> compressed = new ArrayList<>();
        compressed.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                compressed.add(nums[i]);
            }
        }
        for (int i = 1; i < compressed.size() - 1; i++) {
            int prev = compressed.get(i - 1);
            int curr = compressed.get(i);
            int next = compressed.get(i + 1);
            if (curr > prev && curr > next) count++; // hill
            else if (curr < prev && curr < next) count++; // valley
        }
        return count;
    }
}
