// Last updated: 5/11/2025, 1:41:06 PM
class Solution {
    public int racecar(int target) {
        int steps = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 1));
        Set<Node> visited = new HashSet<>();
        visited.add(new Node(0, 1));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                int position = node.position, speed = node.speed;
                if (position == target) {
                    return steps;
                } // Move forward
                int nextPosition = position + speed;
                int nextSpeed = speed * 2;
                Node forward = new Node(nextPosition, nextSpeed);
                if (!visited.contains(forward) && 
                Math.abs(nextPosition - target) < target) {
                    queue.offer(forward);
                    visited.add(forward);
                } // Reverse direction
                nextSpeed = speed > 0 ? -1 : 1;
                Node reverse = new Node(position, nextSpeed);
                if (!visited.contains(reverse) && 
                Math.abs(position - target) < target) {
                    queue.offer(reverse);
                    visited.add(reverse);
                }
            }
            steps++;
        }
        return steps;
    }
    static class Node {
        int position, speed;
        Node(int position, int speed) {
            this.position = position;
            this.speed = speed;
        } // must override equals() and hashcode() methods else will TLE
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node other = (Node) o;
            return position == other.position && speed == other.speed;
        } // this method hashes based on VALUE, and not just reference!
        @Override
        public int hashCode() {
            return Objects.hash(position, speed);
        }
    }
}
