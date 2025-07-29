// Last updated: 7/29/2025, 5:41:47 PM
class Solution {
    public int minAnagramLength(String s) {
        for(int i=1;i<=s.length();i++){
            if(s.length()%i==0 && isPossible(s,i)){
                return i;
            }
        }
        return -1;
    }

    public boolean isPossible(String s, int length){
        int [] first=new int [26];
        for(int i=0;i<length;i++){
            first[s.charAt(i)-'a']++;
        }

        for(int i=length;i<s.length();i+=length){
            int [] thisOccurence =new int [26];
            for(int j=i;j<i+length;j++){
                thisOccurence[s.charAt(j)-'a']++;
            }
            for(int k=0;k<26;k++){
                if(thisOccurence[k]!=first[k]){
                    return false;
                }
            }
           
        }
        return true;
    }

}