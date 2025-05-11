// Last updated: 5/11/2025, 12:57:24 PM
class Solution {
    public int racecar(int target) {
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        Set<Integer> visited = new HashSet<>(); //mask: (speed << 14 | position)
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int position = node[0], speed = node[1];
                if (position == target) {
                    return steps;
                } // fwd = [nextPosition, nextSpeed]
                int nextPosition = position + speed, nextSpeed = speed * 2;
                int[] forward = new int[]{nextPosition, nextSpeed};
                int fwdMask = (nextSpeed << 14) | nextPosition;
                if (!visited.contains(fwdMask) && 
                Math.abs(nextPosition - target) < target) {
                    queue.offer(forward); // abs(nextPos - target) < target
                    visited.add(fwdMask); // means we are closer to target!
                } // rev = [position, nextReversedSpeed]
                nextSpeed = speed > 0 ? -1 : 1;
                int revMask = (nextSpeed << 14) | position;
                int[] reverse = new int[]{position, nextSpeed};                
                if (!visited.contains(revMask) && 
                Math.abs(position - target) < target) {
                    queue.offer(reverse); 
                    visited.add(revMask); 
                } // try moving both in fwd and backward directions!
            }
            steps++;
        }
        return steps;
    }
}