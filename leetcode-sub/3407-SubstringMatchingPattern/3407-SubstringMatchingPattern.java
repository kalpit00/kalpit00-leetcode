// Last updated: 10/4/2025, 6:25:21 AM
class Solution {
    public boolean hasMatch(String s, String p) {
        int index = p.indexOf('*');
        int firstpos = s.indexOf(p.substring(0, index)); 
// finding if the pre * pattern is present in the word , if not its -1
        int secondpos = s.indexOf(p.substring(index + 1), firstpos + index); 
// finding if the post * pattern is present in the word , if not its -1
        if (firstpos != -1 && secondpos != -1) {
// comparing if both the firstpos and secondpos are not -1 , if not then it means both patterns are present in the word
            return true;
        }
        return false;
    }
}