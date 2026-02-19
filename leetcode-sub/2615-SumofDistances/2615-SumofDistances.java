// Last updated: 2/19/2026, 2:45:38 AM
1class Solution {
2    public long[] distance(int[] arr) {
3        long[] output = new long[arr.length];
4        Map<Integer, Long> sumMap = new HashMap<>();
5        Map<Integer, Integer> countMap = new HashMap<>();
6        for (int i = 0; i < arr.length; ++i) {
7            if (!sumMap.containsKey(arr[i])) {
8                sumMap.put(arr[i], 0l);
9                countMap.put(arr[i], 0);
10            }
11
12            output[i] += i * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
13            sumMap.put(arr[i], sumMap.get(arr[i]) + i);
14            countMap.put(arr[i], countMap.get(arr[i]) + 1);
15        }
16
17        sumMap = new HashMap<>();
18        countMap = new HashMap<>();
19        int len = arr.length;
20        for (int i = len - 1; i >= 0; --i) {
21            if (!sumMap.containsKey(arr[i])) {
22                sumMap.put(arr[i], 0l);
23                countMap.put(arr[i], 0);
24            }
25
26            output[i] += (len - i - 1) * (long) countMap.get(arr[i]) - sumMap.get(arr[i]);
27            sumMap.put(arr[i], sumMap.get(arr[i]) + (len - i - 1));
28            countMap.put(arr[i], countMap.get(arr[i]) + 1);
29        }
30
31        return output;
32    }
33}