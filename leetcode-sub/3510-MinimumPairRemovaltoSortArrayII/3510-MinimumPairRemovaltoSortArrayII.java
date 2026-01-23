// Last updated: 1/22/2026, 8:00:36 PM
1class Solution {
2    public int minimumPairRemoval(int[] arr) {
3        int n = arr.length, count = 0, res = 0;
4        long[] nums = new long[n];
5        for (int i = 0; i < n; i++) {
6            nums[i] = arr[i];
7        }
8        int[] l = new int[n+1], r = new int[n+1];
9        for (int i = 0; i < n; i++) {
10            l[i] = i - 1;
11            r[i] = i + 1;
12        }
13        // Min-Heap: Stores {sum, index}
14        // Orders by smallest sum, ties broken by smallest index (leftmost)
15        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] 
16        ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
17        boolean[] visited = new boolean[n];
18        for(int i = 0; i < n - 1; i++) {
19            pq.offer(new long[]{nums[i] + nums[i + 1], i});
20            count += nums[i] > nums[i + 1] ? 1 : 0;
21        }
22        if (count == 0) {
23            return 0;
24        } // If already sorted, 0 ops
25        while (count > 0) {
26            long[] b = pq.poll();
27            long sum = b[0];
28            int i = (int) b[1], j = r[i]; // j == right neighbor of i
29            if (visited[i] || j == n) continue;
30            if (sum != nums[i] + nums[j]) continue;
31            if (l[i] >= 0 && nums[l[i]] > nums[i]) {
32                count--;
33            }
34            if (nums[i] > nums[j]) {
35                count--;
36            }
37            if (r[j] < n && nums[j] > nums[r[j]]) {
38                count--;
39            }
40            visited[j] = true;            
41            if (r[j] != n && l[r[j]] != -1) {
42                l[r[j]] = i;
43            }
44            r[i] = r[j];
45            nums[i] = sum;
46            if (l[i] >= 0 && nums[l[i]] > nums[i]) {
47                count++;
48            }
49            if (r[j] < n && nums[i] > nums[r[j]]) {
50                count++;
51            }
52            if (l[i] >= 0) {
53                pq.offer(new long[]{nums[l[i]] + nums[i], l[i]});
54            }
55            if (r[i] < n) {
56                pq.offer(new long[]{nums[i] + nums[r[i]], i});
57            }
58            res++;
59        }
60        return res;
61    }
62}