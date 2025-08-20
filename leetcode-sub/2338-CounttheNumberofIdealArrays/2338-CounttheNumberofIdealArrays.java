// Last updated: 8/20/2025, 3:03:00 AM
class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num--;
            }
            else {
                num /= 2;
            }
            count++;
        }
        return count;
    }
}