// Last updated: 11/12/2026, 10:22:54 PM
1class Solution {
2    public long countNonDecreasingSubarrays(int[] nums, int k) {
3        int n = nums.length;
4        Deque<Node> deque = new ArrayDeque<>();
5        deque.offer(new Node(1, nums[n - 1]));
6        long res = 1, sum = 0;
7        int count = 1;
8        for (int i = n - 2; i >= 0; i--) {
9            Node node = new Node(1, nums[i]);
10            while (!deque.isEmpty() && deque.peek().num <= nums[i]) {
11                Node prev = deque.poll();
12                node.count += prev.count;
13                sum += (node.num - prev.num) * prev.count;
14            }
15            count++;
16            deque.offerFirst(node);
17            while (sum > k) {
18                count--;
19                sum -= (deque.peekLast().num - nums[i + count]);
20                if (--deque.peekLast().count == 0) {
21                    deque.pollLast();
22                }
23            }
24            res += count;
25        }
26        return res;
27    }
28
29    class Node {
30        long count;
31        int num;
32        public Node(long count, int num) {
33            this.count = count;
34            this.num = num;
35        }
36    }
37}