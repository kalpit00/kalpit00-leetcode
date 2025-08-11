// Last updated: 8/11/2025, 3:47:14 AM
class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        
        boolean visit[][]=new boolean[n][n];
        for(int arr[]:dig){
            visit[arr[0]][arr[1]]=true;
        }
        
        int ans=0;
        for(int arr[]:artifacts){
            
            boolean flag=true;
            for(int i=arr[0];i<=arr[2];i++){
                for(int j=arr[1];j<=arr[3];j++){
                    if(!visit[i][j]) flag=false;
                }
            }
            if(flag) ans++;
        }
        return ans;
    }
}