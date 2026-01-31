// Last updated: 1/30/2026, 11:10:51 PM
1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int n = letters.length, start = 0, end = n - 1, ans = -1;
4        while (start <= end) {
5            int mid = start + (end - start) / 2;
6            if (letters[mid] > target) {
7                ans = mid;
8                end = mid - 1;
9            }                
10            else {
11                start = mid + 1;
12            }
13        }
14        return ans == -1 ? letters[0] : letters[ans];
15    }
16}