// Last updated: 6/15/2025, 2:05:13 AM
class Solution {
    public int minimumSwap(String s1, String s2) {
        int n=s1.length();
        int x=0,y=0;
        int count=0;
        for(int i=0;i<n;i++)
        {
            char ch1=s1.charAt(i);
            char ch2=s2.charAt(i);
            if(ch1=='x' && ch2=='y')
            {
                x++;
            }
            if(ch2=='x' && ch1=='y')
            {
                y++;
            }
            
        }
        if(x%2!=y%2)
        {
            return -1;
        }
      int ans=x/2+y/2;
      if(x%2==1)
      {
        ans+=2;
      }
      return ans;
    }
}