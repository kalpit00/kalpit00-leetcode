// Last updated: 4/19/2025, 10:09:29 PM
class Solution {
    public int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : answers) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            int freq = map.get(key);
            key++;
            count += (freq + key - 1) / key * key;
        }
        return count;
    }
}