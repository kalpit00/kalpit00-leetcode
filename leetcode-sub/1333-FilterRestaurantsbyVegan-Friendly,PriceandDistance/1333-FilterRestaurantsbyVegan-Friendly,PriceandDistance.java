// Last updated: 4/21/2025, 1:09:26 PM
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
        a[1] != b[1] ? b[1] - a[1] : b[0] - a[0]);
        for (int[] item : restaurants) {
            int id = item[0], rating = item[1], vegan = item[2],
            price = item[3], distance = item[4];
            if (price <= maxPrice && distance <= maxDistance && 
            (veganFriendly == 0 || veganFriendly == 1 && vegan == 1)) {
                pq.offer(item);
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}