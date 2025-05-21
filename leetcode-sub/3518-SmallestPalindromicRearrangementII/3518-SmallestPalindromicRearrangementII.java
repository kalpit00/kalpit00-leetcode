// Last updated: 5/21/2025, 6:03:08 PM
class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length(), m = n / 2;
        char[] res = new char[n];
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (map[i] % 2 == 1) {
                map[i]--; // set mid character of pali when odd freq found!
                res[n / 2] = (char) (i + 'a');
            }
            map[i] /= 2;
        }
        if (multinomial(map, k) < k) {
            return "";
        }
        for (int idx = 0; idx < m; idx++) {
            for (int i = 0; i < 26; i++) {
                if (map[i] == 0) continue;
                map[i]--;
                long count = multinomial(map, k);
                if (count >= k) {
                    res[idx] = (char) (i + 'a');
                    res[n - idx - 1] = (char) (i + 'a');
                    break;
                }
                else {
                    k -= count;
                    map[i]++;
                }
            }
        }
        return String.valueOf(res);
    }
    private long multinomial(int[] map, long k) {
        int n = 0;
        for (int i : map) {
            n += i;
        }
        long res = 1;
        for (int i = 0; i < 26; i++) {
            int r = map[i];
            long count = nCr(n, r, k);
            if (count == k + 1) {
                return k + 1;
            }
            res *= count;
            if (res > k) {
                return k;
            }
            n -= r;
        }
        return res;
    }
    private long nCr(int n, int r, long k) {
        long res = 1;
        r = Math.min(r, n - r); // nCr = nC(n - r) haha property
        for (int i = 1; i <= r; i++) {
            res *= (n - i + 1);
            res /= i;
            if (res > k) {
                return k + 1;
            }
        }
        return res;
    }
}