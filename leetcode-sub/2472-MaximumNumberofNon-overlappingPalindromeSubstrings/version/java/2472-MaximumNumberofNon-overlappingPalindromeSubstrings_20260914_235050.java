// Last updated: 9/14/2026, 11:50:50 PM
1class Solution {
2    int count = 0, start = 0;
3    public int maxPalindromes(String s, int k) {
4        for (int i = 0; i < s.length(); i++) {
5            expandFromCenter(s, i, i, k);
6            expandFromCenter(s, i, i + 1, k);
7        }
8        return count;
9    }
10
11    private void expandFromCenter(String s, int left, int right, int k) {
12        while (left >= start && right < s.length() &&
13        s.charAt(left) == s.charAt(right)) {
14            if (right - left + 1 >= k) {
15                count++;
16                start = right + 1; 
17                break;
18            }
19            left--;
20            right++;
21        }
22    }
23}
24