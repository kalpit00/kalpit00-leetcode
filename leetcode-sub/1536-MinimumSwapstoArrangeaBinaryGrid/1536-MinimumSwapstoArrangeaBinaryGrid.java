// Last updated: 3/1/2026, 8:35:04 PM
1class Solution {
2    public int minSwaps(int[][] grid) {
3        int zeroCount[] = new int[grid.length];
4        int ptr=0;
5        for(int[] row : grid){
6            int count=0;
7            for(int i=row.length-1;i>=0;i--){
8                if(row[i]==0) count++;
9                else break;
10            }
11            zeroCount[ptr++] = count;
12        }
13        int ans = 0;
14        for(int i=0;i<zeroCount.length-1;i++){
15            if(zeroCount[i] >= zeroCount.length-i-1) continue;
16            else{
17                boolean found = false;
18                for(int j=i+1;j<zeroCount.length;j++){
19                    if(zeroCount[j] >= zeroCount.length-i-1){
20                        found=true;
21                        ans += j-i;
22                        while(j>i){
23                            int temp = zeroCount[j-1];
24                            zeroCount[j-1] = zeroCount[j];
25                            zeroCount[j] = temp;
26                            j--;
27                        }
28                        break;
29                    }
30                }
31                if(!found) return -1;
32            }
33        }
34    return ans;
35    }
36}