// Last updated: 3/29/2025, 8:41:35 PM
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[][] map = new int[26][2];
        for (int[] r : map) {
            Arrays.fill(r, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            map[c][0] = map[c][0] == -1 ? i : map[c][0];
            map[c][1] = i;
        }
        List<int[]> intervals = new ArrayList<>();
        for (int[] interval : map) {
            if (interval[0] != -1) {
                intervals.add(interval);
            }
        }
        intervals = merge(intervals);
        List<Integer> res = new ArrayList<>();
        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            res.add(end - start + 1);
        }
        return res;
    }
    public List<int[]> merge(List<int[]> intervals) {
        Collections.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int[] prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        res.add(prev);
        // return res.toArray(new int[0][]);
        return res;
    }
}