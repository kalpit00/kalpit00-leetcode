// Last updated: 8/15/2025, 10:12:38 PM
class Solution {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        int n = num, res = 0;
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            res = res * 10 + list.get(i);
        }
        return res;
    }
}