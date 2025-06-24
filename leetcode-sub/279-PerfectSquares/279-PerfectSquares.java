// Last updated: 6/24/2025, 7:53:23 PM
class Solution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        set.add(1L);
        Long num = 1L;
        for (int i = 0; i < n; i++) {
            num = set.pollFirst(); // poll 'n' times for nth ugly number!
            set.add(num * 2);
            set.add(num * 3);
            set.add(num * 5);
        }
        return num.intValue();
    }
}