// Last updated: 10/4/2025, 6:18:27 AM
class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        Map<Integer, Map<Integer, Integer>> playerPicks = new HashMap<>();

        for (int i = 0; i < n; i++) {
            playerPicks.put(i, new HashMap<>());
        }

        for (int[] p : pick) {
            int playerId = p[0];
            int colorId = p[1];
            Map<Integer, Integer> colorCounts = playerPicks.get(playerId);
            colorCounts.put(colorId, colorCounts.getOrDefault(colorId, 0) + 1);
        }

        int winningPlayers = 0;

        for (int playerId = 0; playerId < n; playerId++) {
            int requiredCount = playerId + 1;
            boolean wins = false;
            
            Map<Integer, Integer> colorCounts = playerPicks.get(playerId);
            
            for (int count : colorCounts.values()) {
                if (count >= requiredCount) {
                    wins = true;
                    break;
                }
            }
            
            if (wins) {
                winningPlayers++;
            }
        }

        return winningPlayers;
    }
}