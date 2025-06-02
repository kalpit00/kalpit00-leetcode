// Last updated: 6/1/2025, 8:03:29 PM
class Solution {
    public int maxSubstrings(String word) {
        int n = word.length(), prevEnd = -1, count = 0;
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 3; j < n; ++j) {
                if (word.charAt(i) == word.charAt(j)) {
                    intervals.add(new int[]{i, j});
                    break;
                }
            }
        }
        intervals.sort((a, b) -> a[1] - b[1]);
        for (int[] interval : intervals) {
            if (prevEnd < interval[0]) {
                prevEnd = interval[1];
                count++;
            } // if prevEnd < currStart, non overlapping. count it
        } // and consume curr, so prevEnd = currEnd!
        return count;
    }
}
