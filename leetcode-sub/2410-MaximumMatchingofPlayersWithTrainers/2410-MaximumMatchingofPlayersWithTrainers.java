// Last updated: 7/13/2025, 7:43:58 PM
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length, i = 0, j = 0, count = 0;
        while (i < m && j < n) {
            if (players[i] <= trainers[j]) {
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}