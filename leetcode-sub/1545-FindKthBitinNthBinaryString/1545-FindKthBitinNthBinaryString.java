// Last updated: 3/2/2026, 9:58:25 PM
1class Solution {
2
3    public char findKthBit(int n, int k) {
4        // Find the position of the rightmost set bit in k
5        // This helps determine which "section" of the string we're in
6        int positionInSection = k & -k;
7
8        // Determine if k is in the inverted part of the string
9        // This checks if the bit to the left of the rightmost set bit is 1
10        boolean isInInvertedPart = (((k / positionInSection) >> 1) & 1) == 1;
11
12        // Determine if the original bit (before any inversion) would be 1
13        // This is true if k is even (i.e., its least significant bit is 0)
14        boolean originalBitIsOne = (k & 1) == 0;
15
16        if (isInInvertedPart) {
17            // If we're in the inverted part, we need to flip the bit
18            return originalBitIsOne ? '0' : '1';
19        } else {
20            // If we're not in the inverted part, return the original bit
21            return originalBitIsOne ? '1' : '0';
22        }
23    }
24}