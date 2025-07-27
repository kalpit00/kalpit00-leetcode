// Last updated: 7/27/2025, 1:57:09 AM
class Solution {
    int mod = 1000000007;
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length, idx = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, i});
            }
            map.get(nums[i])[1] = i;
        }
        int[][] intervals = new int[map.size()][2];
        for (int key : map.keySet()) {
            intervals[idx++] = map.get(key);
        }
        intervals = merge(intervals);
        return (int) pow(2, intervals.length - 1);
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (prev[1] < curr[0]) {
                res.add(prev);
                prev = curr;
            } else {
                prev[0] = Math.min(prev[0], curr[0]);
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        res.add(prev);
        return res.toArray(new int[0][]);
    }
    public long pow(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }

}