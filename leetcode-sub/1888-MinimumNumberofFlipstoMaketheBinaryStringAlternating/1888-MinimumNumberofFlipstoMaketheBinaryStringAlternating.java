// Last updated: 3/6/2026, 9:16:56 PM
1class Solution {
2    public int minFlips(String s) {
3        char[] arr = s.toCharArray();
4        int count1 = 0, count2 = 0, min1 = 0, min2 = 0, n = arr.length;
5        for (int i = 0; i < n; i++) {
6            if (i % 2 == arr[i] - '0') { // if parity of i matches 0 or 1!
7                count1++; // count parity matches!
8                min1++; // i.e, if 0 is on even indices and 1 is on odd indices!
9            }
10            else { // also use a 2nd parity match counter to reflect min
11                count2++;
12                min2++;
13            } // min each with the other "global" counter
14            min1 = Math.min(min1, count2);
15            min2 = Math.min(min2, count1);
16        }
17        int min = Math.min(count1, count2);
18        return n % 2 == 0 ? min : Math.min(min, Math.min(min1, min2));
19    }
20}