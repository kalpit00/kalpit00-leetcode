// Last updated: 12/24/2025, 8:06:07 PM
1class Solution {
2    public int minJumps(int[] nums) {
3        int n = nums.length, steps = 0;
4        Map<Integer, List<Integer>> map = new HashMap<>();
5        for (int i = 0; i < n; i++) {
6            map.putIfAbsent(nums[i], new ArrayList<>());
7            map.get(nums[i]).add(i);
8        }
9        Queue<Integer> queue1 = new LinkedList<>(), queue2 = new LinkedList();
10        boolean[] visited1 = new boolean[n], visited2 = new boolean[n];
11        queue1.offer(0);
12        queue2.offer(n - 1);
13        visited1[0] = true;
14        visited2[n - 1] = true;
15        while (!queue1.isEmpty() && !queue2.isEmpty()) {
16            if (queue1.size() > queue2.size()) {
17                Queue<Integer> tempQueue = queue1;
18                queue1 = queue2;
19                queue2 = tempQueue;
20                boolean[] tempVisited = visited1;
21                visited1 = visited2;
22                visited2 = tempVisited;
23            }
24            int size = queue1.size();
25            for (int k = 0; k < size; k++) {
26                int i = queue1.poll();
27                if (visited2[i]) {
28                    return steps;
29                }
30                Set<Integer> set = new HashSet<>();
31                if (i + 1 < n) {
32                    set.add(i + 1);
33                }
34                if (i - 1 >= 0) {
35                    set.add(i - 1);
36                }
37                for (int idx : map.get(nums[i])) {
38                    if (idx == i) continue;
39                    set.add(idx);
40                }
41                map.get(nums[i]).clear();
42                for (int j : set) {
43                    if (!visited1[j]) {
44                        visited1[j] = true;
45                        queue1.offer(j);
46                    }
47                }
48            }
49            steps++;
50        }
51        return -1;
52    }
53}