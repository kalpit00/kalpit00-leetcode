// Last updated: 8/9/2026, 8:21:30 AM
1class Solution {
2    public boolean detectCapitalUse(String word) {
3        int n=word.length();
4        int c=0;
5        for(int i=0;i<word.length();i++){
6            char ch=word.charAt(i);
7            if(ch>='A' && ch<='Z'){
8                c++;
9            }
10        }
11        if(c==n){
12            return true;
13        }
14        if(c==0){
15            return true;
16        }
17        if(c==1 && word.charAt(0)>='A' && word.charAt(0)<='Z'){
18            return true;
19        }
20        return false;
21    }
22}