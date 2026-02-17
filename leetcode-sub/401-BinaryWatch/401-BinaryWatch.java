// Last updated: 2/16/2026, 7:18:25 PM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        // brute force method, count no of 1 bits in every possible hour::minute 
4        // combination, and if their sum == no of LED lights, add to result list
5        List<String> results = new ArrayList();
6        for (int i = 0; i < 12; i++) {
7            for (int j = 0; j < 60; j++) {
8                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
9                    if (j < 10) {
10                        results.add(String.format("%d:0%d", i, j));
11                    }
12                    else {
13                        results.add(String.format("%d:%d", i, j));
14                    }
15                }
16            }
17        }
18        return results;
19    }
20}