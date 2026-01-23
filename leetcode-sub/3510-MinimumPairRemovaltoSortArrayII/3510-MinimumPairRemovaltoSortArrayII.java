// Last updated: 1/22/2026, 7:45:04 PM
1class Solution {
2    public int minimumPairRemoval(int[] nums) {
3        int n = nums.length;
4        // Use long to prevent integer overflow when summing elements
5        long[] num = new long[n];
6        for(int i = 0; i<n; i++) num[i] = nums[i];
7
8        // Simulated Doubly Linked List
9        int[] L = new int[n+1];
10        int[] R = new int[n+1];
11
12        for(int i = 0; i<n; i++) {
13            L[i] = i-1;
14            R[i] = i+1;
15        }
16
17        // Min-Heap: Stores {sum, index}
18        // Orders by smallest sum, ties broken by smallest index (leftmost)
19        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
20            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
21            return Long.compare(a[1], b[1]);
22        });
23
24        boolean[] remove = new boolean[n];
25        int bad = 0; // Count of inversions
26
27        // Initial population
28        for(int i = 0; i<n-1; i++) {
29            pq.offer(new long[]{num[i]+num[i+1], i});
30            if(num[i] > num[i+1]) bad++;
31        }
32
33        // If already sorted, 0 ops
34        if(bad == 0) return 0;
35
36        int op = 0;
37        while(bad > 0) {
38            long[] b = pq.poll();
39
40            long sum = b[0];
41            int i = (int)b[1];
42            int j = R[i]; // The current right neighbor of i
43
44            // 1. Validation: Skip if i is removed, j is out of bounds, 
45            // or if the heap entry is stale (sum doesn't match current reality)
46            if(remove[i] || j == n) continue;
47            if(sum != num[i] + num[j]) continue;
48
49            // 2. Remove contribution of old connections to 'bad' count
50            if(L[i] != -1 && num[L[i]] > num[i]) bad--;
51            if(num[i] > num[j]) bad--;
52            if(R[j] != n && num[j] > num[R[j]]) bad--;
53
54            // 3. Perform Merge
55            remove[j] = true; // Delete j
56            
57            // Re-link: i connects to R[j]
58            if(R[j] != n && L[R[j]] != -1) L[R[j]] = i; 
59            R[i] = R[j];
60            
61            num[i] = sum; // Update value of i
62
63            // 4. Add contribution of new connections to 'bad' count
64            if(L[i] != -1 && num[L[i]] > num[i]) bad++;
65            if(R[j] != n && num[i] > num[R[j]]) bad++; // Check i vs new right neighbor
66
67            // 5. Add new potential pairs to Heap
68            if(L[i] != -1) pq.offer(new long[]{num[L[i]]+num[i], L[i]});
69            if(R[i] != n) pq.offer(new long[]{num[i]+num[R[i]], i});
70
71            op++;
72        }
73
74        return op;
75    }
76}