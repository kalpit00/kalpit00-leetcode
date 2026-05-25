// Last updated: 5/24/2026, 10:15:28 PM
1class Solution {
2    public boolean canReach(String s, int minJump, int maxJump) {
3        int n = s.length(), max = 0;
4        char[] arr = s.toCharArray();
5        if (arr[n - 1] == '1') {
6            return false;
7        }
8        Queue<Integer> queue = new LinkedList<>();
9        queue.add(0);
10        while (!queue.isEmpty()) {
11            int pos = queue.poll();
12            if (pos == n - 1) {
13                return true;
14            }
15            int l = Math.max(pos + minJump, max); 
16            int r = Math.min(pos + maxJump, n - 1);
17            for (int i = l; i <= r; i++) {
18                if (arr[i] == '0') {
19                    queue.offer(i);
20                }
21            }
22            max = r + 1;
23        }
24        return false;
25    }
26}