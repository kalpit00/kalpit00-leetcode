// Last updated: 3/7/2026, 7:15:25 PM
1class Solution {
2    public String findDifferentBinaryString(String[] nums) {
3        StringBuilder sb = new StringBuilder();
4        for (int i = 0; i < nums.length; i++) {
5            Character curr = nums[i].charAt(i);
6            sb.append(curr == '0' ? '1' : '0');
7        }
8        return sb.toString();
9    }
10}