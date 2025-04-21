// Last updated: 4/21/2025, 1:05:47 PM
class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<int[]> list = new ArrayList<>();
        for (int[] item : restaurants) {
            int id = item[0], rating = item[1], vegan = item[2],
            price = item[3], distance = item[4];
            if (price <= maxPrice && distance <= maxDistance && 
            (veganFriendly == 0 || veganFriendly == 1 && vegan == 1)) {
                list.add(item);
            }
        }
        Collections.sort(list, (a, b) -> a[1] != b[1] ? b[1] - a[1] : 
        b[0] - a[0]);
        List<Integer> res = new ArrayList<>();
        for (int[] item : list) {
            res.add(item[0]);
        }
        return res;
    }
}