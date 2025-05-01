// Last updated: 5/1/2025, 6:52:30 PM
class Solution {
    public int maximumValue(String[] strs) {
        int max = Integer.MIN_VALUE;
        label:
        for (String str : strs) {
            int num = 0;
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    max = Math.max(max, str.length());
                    continue label;
                }
                else {
                    num = num * 10 + (c - '0');
                }
            }
            max = Math.max(max, num);
        }
        return max;
    }
}