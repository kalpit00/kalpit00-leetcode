// Last updated: 9/23/2025, 4:19:12 AM
class Solution {
    public int totalNumbers(int[] digits) {
        int[] map = new int[10];
        boolean flag = false;
        for (int num : digits) {
            map[num]++;
            flag = num % 2 == 0 ? true : flag;
        }
        if (!flag) {
            return 0; // no even digits to put on last place
        }
        int count = 0;
        for (int i = 1; i < 10; i++) {
            if (map[i] == 0) continue;
            map[i]--;
            for (int j = 0; j < 10; j++) {
                if (map[j] == 0) continue;
                map[j]--;
                for (int k = 0; k < 10; k += 2) {
                    if (map[k] == 0) continue;
                    count++;
                }
                map[j]++;
            }
            map[i]++;
        }
        return count;
    }
}