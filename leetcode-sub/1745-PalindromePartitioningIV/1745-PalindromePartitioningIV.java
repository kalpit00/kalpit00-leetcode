// Last updated: 5/13/2025, 9:34:08 PM
class Solution {
    int result = 0;
    int start = 0;
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        for(int i = 0; i<n; i++){
            extendPalindrom(s, i, i, k);
            extendPalindrom(s, i, i+1, k);
        }

        return result;
    }

    public void extendPalindrom(String s, int left, int right, int k){
        while(left>=start && right<s.length() && s.charAt(left) == s.charAt(right)){
            if(right-left+1 >= k){
                result++;
                start = right+1;
                break;
            }
            left--; right++;
        }
    }
}