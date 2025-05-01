// Last updated: 5/1/2025, 5:18:01 PM
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Integer[] map = new Integer[26];
        char[] ch = chars.toCharArray(), arr = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            map[ch[i] - 'a'] = vals[i];
        }
        for (int i = 0; i < 26; i++) {
            map[i] = map[i] == null ? i + 1 : map[i];
        }
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = map[arr[i] - 'a'];
        }
        int res = kadanes(nums);
        return res < 0 ? 0 : res;
    }
    public int kadanes(int[] nums) {
        int sum = 0, max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }
}