// Last updated: 9/25/2026, 8:27:30 PM
1class Solution {
2    public String evaluate(String s, List<List<String>> knowledge) {
3        Map<String, String> map = new HashMap<>();
4        for (List<String> pair : knowledge) {
5            map.putIfAbsent(pair.get(0), pair.get(1));
6        }
7        StringBuilder sb = new StringBuilder();
8        char[] arr = s.toCharArray();
9        int n = arr.length;
10        for (int i = 0; i < n; i++) {
11            if (arr[i] == '(') {
12                int j = i + 1;
13                while (arr[i] != ')' && i < n) {
14                    i++;
15                }
16                String key = String.valueOf(arr, j, i - j);
17                sb.append(map.getOrDefault(key, "?"));
18            }
19            else {
20                sb.append(arr[i]);
21            }
22        }
23        return sb.toString();
24    }
25}