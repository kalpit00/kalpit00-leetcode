// Last updated: 5/12/2025, 8:06:37 AM
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] map = new int[10];
        for (int digit : digits) {
            map[digit]++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 100; i < 1000; i += 2) {
            int a = i % 10, b = (i / 10) % 10, c = i / 100;
            map[a]--; // parse the 3 digits from all num between [100, 999]
            map[b]--;
            map[c]--;
            if (map[a] >= 0 && map[b] >= 0 && map[c] >= 0) {
                ans.add(i); // make sure none are leading zeroes
            }
            map[a]++;
            map[b]++;
            map[c]++;
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}