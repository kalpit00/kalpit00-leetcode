// Last updated: 7/30/2025, 1:32:00 AM
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int k = queries[i][0], trim = queries[i][1];
            String[] trimmed = new String[n];
            for (int j = 0; j < n; j++) {
                trimmed[j] = nums[j].substring(nums[j].length() - trim);
            }
            Integer[] indices = new Integer[n];
            for (int j = 0; j < n; j++) indices[j] = j;
            Arrays.sort(indices, (a, b) -> {
                int cmp = trimmed[a].compareTo(trimmed[b]);
                if (cmp != 0) return cmp;
                return Integer.compare(a, b);
            });
            res[i] = indices[k - 1];
        }
        return res;
    }
}
