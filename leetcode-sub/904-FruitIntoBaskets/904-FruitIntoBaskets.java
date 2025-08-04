// Last updated: 8/3/2025, 8:11:49 PM
class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length, left = 0, right = 0, counter = 0, max = 0;
        int[] map = new int[n+1];
        while (right < n) {
            if (map[fruits[right]] == 0) {
                counter++;
            }
            map[fruits[right]]++;
            right++;
            if (counter > 2) {
                if (map[fruits[left]] == 1) {
                    counter--;
                }
                map[fruits[left]]--;
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}