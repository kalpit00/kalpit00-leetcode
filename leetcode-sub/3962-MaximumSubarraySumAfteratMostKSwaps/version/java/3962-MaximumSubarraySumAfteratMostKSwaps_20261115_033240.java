// Last updated: 11/15/2026, 3:32:40 AM
1class Solution {
2    public int longestArithmetic(int[] v) {
3        int n = v.length;
4        int[] dpl = new int[n];
5        int[] dpr = new int[n];
6        Arrays.fill(dpl,2);
7        Arrays.fill(dpr,2);
8
9        int ans = 2;
10        dpl[0] = 1;
11
12        for(int i=2;i<n;i++){
13            if(v[i]-v[i-1] == v[i-1]-v[i-2])
14                dpl[i] = dpl[i-1] + 1;
15            else
16                dpl[i] = 2;
17        }
18
19        dpr[n-1] = 1;
20
21        for(int i=n-3;i>=0;i--){
22            if(v[i+1]-v[i] == v[i+2]-v[i+1])
23                dpr[i] = dpr[i+1] + 1;
24            else
25                dpr[i] = 2;
26        }
27
28        for(int i=0;i<n;i++){
29
30            if(i>0) ans = Math.max(ans , dpl[i-1] + 1);
31            if(i+1<n) ans = Math.max(ans , dpr[i+1] + 1);
32
33            if(i>0 && i+1<n){
34                int diff = v[i+1] - v[i-1];
35
36                if(diff % 2 != 0) continue;
37
38                int len = 1;
39
40                if(i-2>=0 && v[i-1]-v[i-2] == diff/2)
41                    len += dpl[i-1];
42                else
43                    len += 1;
44
45                if(i+2<n && v[i+2]-v[i+1] == diff/2)
46                    len += dpr[i+1];
47                else
48                    len += 1;
49
50                ans = Math.max(ans , len);
51            }
52        }
53
54        return ans;
55    }
56}