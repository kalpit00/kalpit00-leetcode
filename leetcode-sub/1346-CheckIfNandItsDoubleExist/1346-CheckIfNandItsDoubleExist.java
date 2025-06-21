// Last updated: 6/21/2025, 3:45:39 PM
class Solution {
    public String rankTeams(String[] votes) {
        int n = votes[0].length();
        int[][] map = new int[26][n + 1];
        for (int i = 0; i < 26; i++) {
            map[i][n] = i;
        }
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                map[vote.charAt(i) - 'A'][i]++;
            }
        }
        Comparator<int[]> comparator = (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (a[i] > b[i]) return -1;
                if (a[i] < b[i]) return 1;
            }
            return 0;
        };
        Arrays.sort(map, comparator);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (map[i][n] + 'A'));
        }
        return sb.toString();
    }
}