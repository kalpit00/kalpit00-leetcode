// Last updated: 5/14/2025, 12:09:09 PM
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, 
        n = barcodes.length, idx = 0;
        for (int b : barcodes) {
            min = Math.min(min, b);
            max = Math.max(max, b);
        }
        int range = max - min + 1;
        int[] freq = new int[range], res = new int[n];
        for (int b : barcodes) {
            freq[b - min]++;
        }
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < range; i++) {
            if (freq[i] > 0) {
                buckets[freq[i]].add(i + min);
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
