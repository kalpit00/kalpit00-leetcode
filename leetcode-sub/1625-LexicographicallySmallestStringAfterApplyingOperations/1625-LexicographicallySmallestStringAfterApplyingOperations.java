// Last updated: 10/18/2025, 9:22:41 PM
class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();
        String ans = s;

        q.offer(s);
        vis.add(s);

        while (!q.isEmpty()) {
            String curr = q.poll();
            if (curr.compareTo(ans) < 0) ans = curr;

            // Operation 1: Add 'a' to odd indices
            char[] ch = curr.toCharArray();
            for (int i = 1; i < ch.length; i += 2) {
                ch[i] = (char) (((ch[i] - '0' + a) % 10) + '0');
            }
            String addOp = new String(ch);
            if (vis.add(addOp)) q.offer(addOp);

            // Operation 2: Rotate right by b positions
            String rotateOp = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);
            if (vis.add(rotateOp)) q.offer(rotateOp);
        }

        return ans;
    }
}