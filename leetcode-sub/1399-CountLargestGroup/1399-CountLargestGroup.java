// Last updated: 4/22/2025, 10:26:10 PM
class Solution {
    public int countLargestGroup(int n) {
        int max = 0, count = 0;
        int[] map = new int[37];
        for (int i = 1; i <= n; i++) {
            int num = i, sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            map[sum]++;
            max = Math.max(max, map[sum]);
        }
        for (int i = 0; i < 37; i++) {
            count += map[i] == max ? 1 : 0;
        }
        return count;
    }
}