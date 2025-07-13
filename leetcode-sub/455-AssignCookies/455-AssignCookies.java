// Last updated: 7/12/2025, 11:29:20 PM
class Solution {
    public int findContentChildren(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length, i = 0, j = 0, count = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                count++;
            }
            else {
                j++;
            }
        }
        return count;
    }
}