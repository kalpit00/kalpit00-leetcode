// Last updated: 5/31/2026, 5:30:07 AM
1class Solution {
2    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
3        Arrays.sort(asteroids);
4        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
5        int n = asteroids.length, j = 0;
6        for (int i = 0; i < n; i++) {
7            while (j < n && asteroids[j] <= mass) {
8                maxHeap.offer(asteroids[j]);
9                j++;
10            }            
11            if (maxHeap.isEmpty()) {
12                return false;
13            }            
14            mass += maxHeap.poll();
15        }   
16        return true;
17    }
18}