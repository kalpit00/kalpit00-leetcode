// Last updated: 1/25/2026, 8:57:43 PM
1class Solution {
2    public List<List<Integer>> minimumAbsDifference(int[] arr) {
3        Arrays.sort(arr);
4        int n = arr.length, min = Integer.MAX_VALUE;
5        List<List<Integer>> res = new ArrayList<>();
6        for (int i = 1; i < n; i++) {
7            min = Math.min(min, arr[i] - arr[i - 1]);
8        }
9        for (int i = 1; i < n; i++) {
10            if (arr[i] - arr[i - 1] == min) {
11                res.add(List.of(arr[i - 1], arr[i]));
12            }
13        }
14        return res;
15    }
16}