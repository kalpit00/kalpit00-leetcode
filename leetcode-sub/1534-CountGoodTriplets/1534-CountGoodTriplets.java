// Last updated: 4/14/2025, 12:06:43 AM
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count=0;
        int l=arr.length;
        for(int i=0;i<l-2;i++){
            for(int j=i+1;j<l-1;j++){
                if(Math.abs(arr[i]-arr[j]) <= a ){
                    for(int k=j+1;k<l;k++){
                        if(Math.abs(arr[j]-arr[k]) <=b && 
                        Math.abs(arr[i]-arr[k]) <=c){
                            count++;
                        }
                    }
                }
            }
        }return count;
    }
}