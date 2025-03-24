// Last updated: 3/24/2025, 9:01:55 AM
import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length; // Number of users
        Set<Integer>[] set = new HashSet[m + 1];

        // Convert languages to sets for each user
        for (int i = 1; i <= m; i++) {
            set[i] = new HashSet<>();
            for (int language : languages[i - 1]) { // 0-based index
                set[i].add(language);
            }
        }

        // Find users who cannot communicate
        Set<Integer> toTeach = new HashSet<>();
        for (int[] friendship : friendships) {
            int u = friendship[0], v = friendship[1]; // 1-based indices
            Set<Integer> langU = set[u], langV = set[v];

            boolean canCommunicate = false;
            for (int lang : langU) {
                if (langV.contains(lang)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                toTeach.add(u);
                toTeach.add(v);
            }
        }

        // Find the minimum number of people to teach for an optimal language
        Map<Integer, Integer> langCount = new HashMap<>();
        for (int user : toTeach) {
            for (int lang : set[user]) {
                langCount.put(lang, langCount.getOrDefault(lang, 0) + 1);
            }
        }

        int maxCommon = 0;
        for (int count : langCount.values()) {
            maxCommon = Math.max(maxCommon, count);
        }

        return toTeach.size() - maxCommon;
    }
}
