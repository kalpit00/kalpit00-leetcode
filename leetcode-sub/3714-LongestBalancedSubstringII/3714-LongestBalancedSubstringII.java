// Last updated: 2/12/2026, 8:52:43 PM
1class Solution {
2    public int longestBalanced(String s) {
3        int n = s.length();
4        int len = 1; int max = 1;
5        for(int i=1; i<n; i++){
6            if(s.charAt(i) == s.charAt(i-1)){
7                len++;
8                max = Math.max(max, len);
9            } else {
10                len = 1;
11            }
12        }
13        int a = 0, b = 0, c = 0;
14        Map<String, Integer> map = new HashMap<>();
15        map.put("0,0", -1);
16        for(int i=0; i<n; i++){
17            char ch = s.charAt(i);
18            if(ch == 'a'){
19                a++;
20            } else if(ch == 'b'){
21                b++;
22            } else {
23                c++;
24            }
25            int diff1 = a - b; int diff2 = a - c;
26            String key = diff1 + "," + diff2;
27            if(map.containsKey(key)){
28                max = Math.max(max, i-map.get(key));
29            } else {
30                map.put(key, i);
31            } 
32        }
33        max = Math.max(max, solve(s, 'a', 'b', 'c'));
34        max = Math.max(max, solve(s, 'a', 'c', 'b'));
35        max = Math.max(max, solve(s, 'b', 'c', 'a'));
36
37        return max;
38    }
39    public int solve(String s, char c1, char c2, char skip){
40        int maxLen = 0; int n = s.length();
41        for(int i=0; i<s.length(); i++){
42            while(i < n && s.charAt(i) == skip) i++;
43            if(i >= n) break;
44            int p = i;
45            while(i < n && s.charAt(i) != skip) i++;
46            int q = i-1; int x = 0; int y = 0;
47            Map<Integer, Integer> map = new HashMap<>();
48            map.put(0, p-1);
49            for(int j=p; j<=q; j++){
50                char ch = s.charAt(j);
51                if (ch == c1){
52                    x++;
53                } else if(ch == c2){
54                    y++;
55                }
56                int key = x-y;
57                if(map.containsKey(key)){
58                    maxLen = Math.max(maxLen, j-map.get(key));
59                } else {
60                    map.put(key, j);
61                }
62            }
63        }
64        return maxLen;
65    }
66}