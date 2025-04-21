// Last updated: 4/21/2025, 1:10:36 PM
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]);
        for (int[] r : restaurants)
        	if ((veganFriendly == 0 || r[2] == veganFriendly) && r[3] <= maxPrice && r[4] <= maxDistance)
        		pq.offer(r);
        while (!pq.isEmpty())
        	res.add(pq.poll()[0]);
        return res;
    }
}