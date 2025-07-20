// Last updated: 7/20/2025, 2:34:54 AM
class Solution {
    public String largestNumber(int[] cost, int target) {

        String[][] dp=new String[cost.length+1][target+1];

        for(String arr[]:dp){
            Arrays.fill(arr,null);
        }
        return f(cost.length-1,cost,target,dp);    
    }

    public String f(int i,int[] cost,int target,String[][] dp){

        if(target==0){
            return "";
        }
        if(i<0){
           return "0";  
            
        }
        if(dp[i][target]!=null){
            return dp[i][target];
        }
        String pick="";
        String max="0";

        if(target>=cost[i]){
            pick=f(i,cost,target-cost[i],dp);
            if(!pick.equals("0")){
                max=(i+1)+pick;
            }
        }

        String notpick=f(i-1,cost,target,dp);

        if(notpick.length()>max.length() || notpick.length()==max.length() && notpick.compareTo(max)>0  ){
            max=notpick;
        }

        return dp[i][target]=max;


    }
}