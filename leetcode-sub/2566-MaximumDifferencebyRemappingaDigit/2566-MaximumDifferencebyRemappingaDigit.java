// Last updated: 6/13/2025, 8:35:38 PM
class Solution {
    public int minMaxDifference(int num) {
        int[] nums = getDigits(num);
        return getNum(nums.clone(), 9) - getNum(nums.clone(), 0);
    }
    private int[] getDigits(int num) {
        int n = (int) Math.log10(num) + 1, idx = n - 1;
        int[] digits = new int[n];
        while (num > 0) {
            digits[idx--] = num % 10;
            num /= 10;
        }
        return digits;
    }
    private int getNum(int[] digits, int newNum) {
        int oldNum = -1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != newNum) {
                oldNum = digits[i];
                break;
            }
        }
        for (int i = 0; i < digits.length; i++) {
            digits[i] = digits[i] == oldNum ? newNum : digits[i];            
        }
        int num = 0;
        for (int d : digits) {
            num = num * 10 + d;
        }
        return num;
    }
}