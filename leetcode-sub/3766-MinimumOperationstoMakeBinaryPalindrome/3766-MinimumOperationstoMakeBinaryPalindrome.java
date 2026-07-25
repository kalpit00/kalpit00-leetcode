// Last updated: 7/24/2026, 8:21:20 PM
1class Solution {
2    public int[] minOperations(int[] nums) {
3        int n = nums.length;
4        int[] res = new int[n];
5        List<Integer> list = new ArrayList<>();
6        boolean[] visited = new boolean[5001];
7        for (int i = 1; i <= 5000; i++) {
8            if (isPalindrome(Integer.toBinaryString(i).toCharArray())) {
9                list.add(i);
10                visited[i] = true;
11            }
12        }
13        for (int i = 0; i < n; i++) {
14            if (visited[nums[i]]) continue;
15            int idx = Collections.binarySearch(list, nums[i]);
16            idx = idx < 0 ? -(idx + 1) : idx;
17            int min = idx < list.size() ? list.get(idx) - nums[i] : 5001;
18            min = idx > 0 ? Math.min(min, nums[i] - list.get(idx - 1)) : min;
19            res[i] = min;
20        }
21        return res;
22    }
23    private boolean isPalindrome(char[] s) {
24        int i = 0, j = s.length - 1;
25        while (i < j) {
26            if (s[i++] != s[j--]) return false;
27        }
28        return true;
29    }
30}