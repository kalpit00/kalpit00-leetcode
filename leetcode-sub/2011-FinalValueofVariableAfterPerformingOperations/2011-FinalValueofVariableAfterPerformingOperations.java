// Last updated: 10/19/2025, 8:38:08 PM
class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int count = 0;
        for (String str : operations) {
            count += str.charAt(0) == '+' || str.charAt(2) == '+' ? 1 : -1;
        }
        return count;
    }
}