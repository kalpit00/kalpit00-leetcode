// Last updated: 10/4/2025, 6:27:34 AM
class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        ArrayList<Integer> l=new ArrayList<>();
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j+=2){
                l.add(grid[i][j]);
            }
            i++;
            if(i==m){
                break;
            }
            int j=n-2;
            if(n%2==0){
                j=n-1;
            }
            for(;j>=0;j-=2){
                l.add(grid[i][j]);
                
            }
        }
        return l;
    }
}