// Last updated: 5/11/2025, 1:20:49 PM
class Solution {
    public int racecar(int target) {
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1}); // [position, speed]
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(0, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int position = node[0], speed = node[1];
                if (position == target) {
                    return steps;
                } // Move forward
                int nextPosition = position + speed;
                int nextSpeed = speed * 2;
                Pair<Integer, Integer> forward = new Pair<>(nextPosition, nextSpeed);
                if (!visited.contains(forward) && 
                Math.abs(nextPosition - target) < target) {
                    queue.offer(new int[]{nextPosition, nextSpeed});
                    visited.add(forward);
                }
                nextSpeed = speed > 0 ? -1 : 1;
                Pair<Integer, Integer> reverse = new Pair<>(position, nextSpeed); // Reverse direction
                if (!visited.contains(reverse) && 
                Math.abs(position - target) < target) {
                    queue.offer(new int[]{position, nextSpeed});
                    visited.add(reverse);
                }
            }
            steps++;
        }
        return steps;
    }
}
