// Last updated: 3/30/2025, 7:15:42 PM
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] map = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            map[c][0] = map[c][0] == 0 ? i + 1 : map[c][0];
            map[c][1] = i + 1;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int[] interval : map) {
            if (interval[0] != 0) {
                intervals.add(interval);
            }
        }
        return merge(intervals);
    }
    public List<Integer> merge(List<int[]> intervals) {
        Collections.sort(intervals, (a,b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        int[] prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            if (prev[1] < curr[0]) {
                res.add(prev[1] - prev[0] + 1);
                prev = curr;
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        res.add(prev[1] - prev[0] + 1);
        return res;
    }
}