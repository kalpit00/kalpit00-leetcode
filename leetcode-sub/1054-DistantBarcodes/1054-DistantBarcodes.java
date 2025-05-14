// Last updated: 5/14/2025, 12:16:56 PM
class Solution {
    public int[] rearrangeBarcodes(int[] nums) {
        int n = nums.length, idx = 0;
        int[] map = new int[10001], res = new int[n];
        for (int num : nums) {
            map[num]++;
        }
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                buckets[map[i]].add(i);
            }
        }
        for (int i = n; i >= 1; i--) {
            for (int val : buckets[i]) {
                int count = i;
                while (count-- > 0) {
                    res[idx] = val;
                    idx += 2;
                    if (idx >= n) {
                        idx = 1;
                    }
                }
            }
        }
        return res;
    }
}
