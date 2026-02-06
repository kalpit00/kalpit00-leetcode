// Last updated: 2/5/2026, 10:33:28 PM
1class Solution {
2    public int[][] generateSchedule(int n) {
3        if (n <= 4) return new int[][]{};
4        
5        int totalMatches = n * (n - 1);
6        int[] gamesPlayed = new int[n];
7        boolean[][] matches = new boolean[n][n];
8        
9        int lastTeam1 = -1, lastTeam2 = -1;
10        int[][] schedule = new int[totalMatches][2];
11        
12        for (int day = 0; day < totalMatches; day++) {
13            int minScore = Integer.MAX_VALUE;
14            int firstTeam = -1, secondTeam = -1;
15            
16            for (int team1 = 0; team1 < n; team1++) {
17                if (team1 == lastTeam1 || team1 == lastTeam2) continue;
18                
19                for (int team2 = 0; team2 < n; team2++) {
20                    if (team2 == lastTeam1 || team2 == lastTeam2) continue;
21                    if (team1 == team2 || matches[team1][team2]) continue;
22                    
23                    int score = gamesPlayed[team1] + gamesPlayed[team2];
24                    if (score < minScore) {
25                        minScore = score;
26                        firstTeam = team1;
27                        secondTeam = team2;
28                    }
29                }
30            }
31            
32            if (firstTeam == -1) return new int[][]{};
33            
34            schedule[day][0] = firstTeam;
35            schedule[day][1] = secondTeam;
36            matches[firstTeam][secondTeam] = true;
37            lastTeam1 = firstTeam;
38            lastTeam2 = secondTeam;
39            gamesPlayed[firstTeam]++;
40            gamesPlayed[secondTeam]++;
41        }
42        
43        return schedule;
44    }
45}