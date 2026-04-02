// Last updated: 4/2/2026, 3:50:28 AM
1class Solution {
2    public int minimumOperations(TreeNode root) {
3        Queue<TreeNode> queue = new LinkedList<>();
4        queue.offer(root);
5        int sum = 0;
6        while (!queue.isEmpty()) {
7            List<Integer> unsorted = new ArrayList<>();
8            int size = queue.size();
9            for (int i = 0; i < size; i++) {
10                TreeNode node = queue.poll();
11                unsorted.add(node.val);
12                if (node.left != null) {
13                    queue.offer(node.left);
14                }
15                if (node.right != null) {
16                    queue.offer(node.right);
17                }
18            }
19            List<Integer> sorted = new ArrayList<>(unsorted);
20            Collections.sort(sorted);
21            sum += countSwaps(sorted, unsorted);
22        }
23        return sum;
24    }
25    public int countSwaps(List<Integer> sorted, List<Integer> unsorted) {
26        int count = 0, n = sorted.size();
27        Map<Integer, Integer> map = new HashMap<>();
28        for (int i = 0; i < n; i++) {
29            map.put(sorted.get(i), i);
30        }
31        for (int i = 0; i < n; i++) {
32            while (i != map.get(unsorted.get(i))) {
33                int correctIdx = map.get(unsorted.get(i));
34                Collections.swap(unsorted, i, correctIdx);
35                count++;
36            }
37        }
38        return count;
39    }
40}