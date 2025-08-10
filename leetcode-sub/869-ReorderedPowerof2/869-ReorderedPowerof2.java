// Last updated: 8/9/2025, 10:58:12 PM
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] map = new int[10];
        int num = n;
        while (num > 0) {
            map[num % 10]++;
            num /= 10;
        }
        for (int i = 0; i < 31; i++) {
            int[] localMap = new int[10];
            int m = 1 << i;
            while (m > 0) {
                localMap[m % 10]++;
                m /= 10;
            }
            if (Arrays.equals(map, localMap)) {
                return true;                
            }
        }
        return false;
    }
}