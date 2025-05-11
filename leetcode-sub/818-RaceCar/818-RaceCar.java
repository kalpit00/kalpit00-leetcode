// Last updated: 5/11/2025, 12:51:56 PM
class Solution {
    public int racecar(int target) {
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        Set<String> visited = new HashSet<>();
        visited.add("0,1");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int position = node[0], speed = node[1];
                if (position == target) {
                    return steps;
                } // Forward move
                int nextPosition = position + speed;
                int nextSpeed = speed * 2;
                String forwardState = nextPosition + "," + nextSpeed;
                if (!visited.contains(forwardState) && 
                Math.abs(nextPosition - target) < target) {
                    queue.offer(new int[]{nextPosition, nextSpeed});
                    visited.add(forwardState);
                } // Reverse move
                nextSpeed = speed > 0 ? -1 : 1;
                String reverseState = position + "," + nextSpeed;
                if (!visited.contains(reverseState) && 
                Math.abs(position - target) < target) {
                    queue.offer(new int[]{position, nextSpeed});
                    visited.add(reverseState);
                }
            }
            steps++;
        }
        return steps;
    }
}
