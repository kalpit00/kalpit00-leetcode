// Last updated: 6/19/2025, 3:26:06 PM
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.toCharArray(), b = s2.toCharArray();
        return ((a[0] == b[0] && a[2] == b[2]) || (a[0] == b[2] && a[2] == b     [0])) && ((a[1] == b[1] && a[3] == b[3]) || (a[1] == b[3] && a[3] == b[1]));
    }
}