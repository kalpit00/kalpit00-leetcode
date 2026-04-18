// Last updated: 4/17/2026, 8:42:55 PM
class Solution {
    public boolean checkDistances(String s, int[] distance) {
        int[] first = new int[26];
        for(int i = 0;i < 26;i++){
            first[i] = -1;}
        for(int i = 0;i < s.length();i++){
            int idx = s.charAt(i) - 'a';
            if(first[idx] == -1){
                first[idx] = i;
            } else{
                int dist = i-first[idx]-1;
                if(dist != distance[idx]){
                    return false;}}}
               return true;
    }}