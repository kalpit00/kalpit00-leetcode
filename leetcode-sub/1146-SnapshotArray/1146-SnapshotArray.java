// Last updated: 8/23/2025, 12:01:02 AM
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7")) continue;
            if (s.contains("2") || s.contains("5") || 
            s.contains("6") || s.contains("9")) {
                count++;
            }
        }
        return count;
    }
}