// Last updated: 8/1/2026, 8:56:46 AM
1class Solution {
2    public String findCommonResponse(List<List<String>> responses) {
3        int max = 0;
4        String ans = "";
5        Map<String, Integer> map = new HashMap<>();
6        for (List<String> response : responses) {
7            Set<String> set = new HashSet<>();
8            for (String s : response) {
9                set.add(s);
10            }
11            for (String s : set) {
12                map.put(s, map.getOrDefault(s, 0) + 1);
13            }
14        }
15        for (Map.Entry<String, Integer> e : map.entrySet()) {
16            if (max < e.getValue()){
17                ans = e.getKey();
18                max = e.getValue();
19            }
20            else if (max == e.getValue()) {
21                if (ans.compareTo(e.getKey()) > 0) {
22                    ans = e.getKey();
23                    max = e.getValue();
24                }
25            }
26        }
27        return ans;
28    }
29}