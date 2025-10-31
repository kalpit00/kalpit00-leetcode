// Last updated: 10/30/2025, 9:45:39 PM
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] map = new int[101], res = new int[2];
        int idx = 0;
        for (int num : nums) {
            map[num]++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 2) {
                res[idx++] = i;
            }
        }
        return res;
    }
}