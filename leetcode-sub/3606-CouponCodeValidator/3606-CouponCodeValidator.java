// Last updated: 12/12/2025, 8:15:02 PM
1class Solution {
2    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
3        List<String>[] arr = new ArrayList[4];
4        for (int i = 0; i < 4; i++) {
5            arr[i] = new ArrayList<>();
6        }
7        Map<String, Integer> map = new HashMap<>();
8        map.put("electronics", 0);
9        map.put("grocery", 1);
10        map.put("pharmacy", 2);
11        map.put("restaurant", 3);
12        int n = code.length;
13        for (int i = 0; i < n; i++) {
14            if (!isActive[i] || !map.containsKey(businessLine[i]) || 
15            !(code[i].matches("[a-zA-Z0-9_]+"))) continue;
16            arr[map.get(businessLine[i])].add(code[i]);
17        }
18        List<String> res = new ArrayList<>();
19        for (int i = 0; i < 4; i++) {
20            Collections.sort(arr[i]);
21            res.addAll(arr[i]);
22        }
23        return res;
24    }
25}