// Last updated: 8/1/2025, 11:40:57 PM
class Solution {
    public int minMoves2(int[] nums) {
    int  median=findKth(nums,0,nums.length-1,nums.length/2),sum=0;
    for(int x:nums){
        sum+=Math.abs(median-x);
    }
    return sum;
    }
    private int findKth(int[] nums,int l,int r,int k){
        while(l<r){
            int p=partition(nums,l,r);
            if(p<k){
                l=p+1;
            }
            else{
                r=p;
            }
        }
        return nums[l];
    }
    private int partition(int[] n,int l,int r){
        int mid =(l+r)/2;
        if(n[mid]<n[l]){
            swap(n,mid,l);
        }
        if(n[r]<n[l]){
            swap(n,l,r);
        }
        if(n[r]<n[mid]){
            swap(n,mid,r);
        }
        int p=n[mid],i=l-1,j=r+1;
        while(true){
            do{
                i++;
            }while(n[i]<p);
            do{
                j--;
            }while(n[j]>p);
            if(i<j){
                swap(n,i,j);
            }
            else{
                return j;
            }
        }
    }

    private void swap(int[] n,int i,int j){
        int tmp=n[i];
        n[i]=n[j];
        n[j]=tmp;
    }
}