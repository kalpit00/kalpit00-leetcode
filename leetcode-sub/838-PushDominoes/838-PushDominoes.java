// Last updated: 5/1/2025, 9:17:41 PM
class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] dis = new int[N];
        int pushDist = 0;
        boolean push = false;
        for(int l=N-1;l>=0;l--){
            if(arr[l]=='L'){
                pushDist=0;
                push=true;
            }
            else if(arr[l]=='R'){
                pushDist=0;
                push=false;
                dis[l]=-1;
            } 
            
            if(push){
                dis[l]= pushDist;
                pushDist++;
            }else{
                dis[l]= Integer.MAX_VALUE;
            }
        }
        //System.out.println(Arrays.toString(dis));

        pushDist = 0;
        push = false;
        for(int i=0;i<N;i++){
            if(arr[i]=='R'){
                pushDist=0;
                push=true;
            }

            if(arr[i]=='L'){
                pushDist=0;
                push=false;
            }  

            if(arr[i] == '.'){
                if(push && pushDist == dis[i]){
                    arr[i] = '.';
                }
                else if(push && pushDist < dis[i]){
                    arr[i] = 'R';
                } else if(dis[i]!= Integer.MAX_VALUE){
                    arr[i] = 'L';
                }
            }
            if(push)pushDist++;
        }
        //System.out.println(new String(arr));
        return new String(arr);
    }
}