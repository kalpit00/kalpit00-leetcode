// Last updated: 3/16/2026, 5:21:28 AM
1class Solution {
2    public int[] smallestTrimmedNumbers(String[] arr, int[][] queries) {
3        int x = arr[0].length(), n = arr.length, m = queries.length;
4        int[] res = new int[m];
5        for (int i = 0; i < m; i++) {
6            int k = queries[i][0], trim = queries[i][1];
7            Node[] nums = new Node[n];
8            for (int j = 0; j < n; j++) {
9                nums[j] = new Node(arr[j].substring(x - trim), j);
10            }
11            quickSelect(nums, 0, n - 1, k - 1);
12            res[i] = nums[k - 1].index;
13        }
14        return res;
15    }
16
17    private void quickSelect(Node[] nums, int start, int end, int k) {
18        if (start >= end) return;
19        int pivotIndex = start + new Random().nextInt(end - start + 1);
20        int[] pivot = partition(nums, start, end, pivotIndex);
21        if (pivot[0] > k) {
22            quickSelect(nums, start, pivot[0] - 1, k);
23        } else if (pivot[1] < k) {
24            quickSelect(nums, pivot[1] + 1, end, k);
25        }
26    }
27
28    private int[] partition(Node[] nums, int start, int end, int pivotIndex) {
29        Node pivotNode = nums[pivotIndex];
30        int i = start, idx = start, j = end;
31        while (idx <= j) {
32            int cmp = compare(nums[idx], pivotNode);
33            if (cmp < 0) {
34                swap(nums, i++, idx++);
35            } else if (cmp > 0) {
36                swap(nums, idx, j--);
37            } else {
38                idx++;
39            }
40        }
41        return new int[]{i, j};
42    }
43    private int compare(Node a, Node b) {
44        int cmp = a.val.compareTo(b.val);
45        return cmp != 0 ? cmp : a.index - b.index;
46    }
47
48    private void swap(Node[] nums, int i, int j) {
49        Node temp = nums[i];
50        nums[i] = nums[j];
51        nums[j] = temp;
52    }
53
54    class Node {
55        String val;
56        int index;
57        public Node(String val, int index) {
58            this.val = val;
59            this.index = index;
60        }
61    }
62}