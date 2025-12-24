// Last updated: 12/24/2025, 5:50:39 PM
1class Solution {
2    public int minJumps(int[] nums) {
3        int n = nums.length, steps = 0;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            map.putIfAbsent(nums[i], new ArrayList<>());
7            map.get(nums[i]).add(i);
8        }
9        Queue<Integer> queue = new LinkedList<>();
10        boolean[] visited = new boolean[n];
11        queue.offer(0);
12        visited[0] = true;
13        while (!queue.isEmpty()) {
14            int size = queue.size();
15            for (int k = 0; k < size; k++) {
16                int i = queue.poll();
17                if (i == n - 1) {
18                    return steps;
19                }
20                Set<Integer> set = new HashSet<>();
21                if (i + 1 < n) {
22                    set.add(i + 1);
23                }
24                if (i - 1 >= 0) {
25                    set.add(i - 1);
26                }
27                for (int idx : map.get(nums[i])) {
28                    if (idx == i) continue;
29                    set.add(idx);
30                }
31                map.get(nums[i]).clear();
32                for (int j : set) {
33                    if (!visited[j]) {
34                        visited[j] = true;
35                        queue.offer(j);
36                    }
37                }
38            }
39            steps++;
40        }
41        return -1;
42    }
43}