// Last updated: 2/28/2026, 7:24:58 PM
1class Solution {
2    public int minPartitions(String n) {
3        int max = 0;
4        for (char c : n.toCharArray()) {
5            max = Math.max(max, c - '0');
6        }
7        return max;
8    }
9}