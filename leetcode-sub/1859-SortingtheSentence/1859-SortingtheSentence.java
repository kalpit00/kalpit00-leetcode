// Last updated: 4/29/2025, 11:46:17 PM
class Solution {
    public int minOperations(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            int x = (int) (Math.log(n) / Math.log(2));
            int prev = (int) Math.pow(2, x);
            int next = (int) Math.pow(2, x + 1);
            n = n - prev <= next - n ? n - prev : next - n;
        }
        return count;
    }
}