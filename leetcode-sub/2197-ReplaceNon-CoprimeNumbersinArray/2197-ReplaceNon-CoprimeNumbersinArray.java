// Last updated: 6/16/2025, 6:11:22 PM
class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        int MAX = 1000001;
        int[] spf = new int[MAX]; // smallest prime factor
        for (int i = 2; i < MAX; i++) {
            if (spf[i] == 0) {
                for (int j = i; j < MAX; j += i) {
                    if (spf[j] == 0) spf[j] = i;
                }
            }
        }

        // prefix and suffix prime factor sets
        Map<Integer, Integer> totalFreq = new HashMap<>();
        List<Map<Integer, Integer>> prefixFreq = new ArrayList<>();
        List<Map<Integer, Integer>> suffixFreq = new ArrayList<>();

        // factorize all nums into suffixFreq
        Map<Integer, Integer> suffixMap = new HashMap<>();
        for (int num : nums) {
            Map<Integer, Integer> curFactors = getFactors(num, spf);
            for (int p : curFactors.keySet()) {
                suffixMap.put(p, suffixMap.getOrDefault(p, 0) + 1);
            }
        }

        Map<Integer, Integer> prefixMap = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            Map<Integer, Integer> cur = getFactors(nums[i], spf);
            for (int p : cur.keySet()) {
                // move from suffix to prefix
                prefixMap.put(p, prefixMap.getOrDefault(p, 0) + 1);
                suffixMap.put(p, suffixMap.get(p) - 1);
                if (suffixMap.get(p) == 0) suffixMap.remove(p);
            }

            boolean valid = true;
            for (int p : prefixMap.keySet()) {
                if (suffixMap.containsKey(p)) {
                    valid = false;
                    break;
                }
            }

            if (valid) return i;
        }

        return -1;
    }

    // Get prime factor map using spf
    private Map<Integer, Integer> getFactors(int num, int[] spf) {
        Map<Integer, Integer> map = new HashMap<>();
        while (num > 1) {
            int prime = spf[num];
            map.put(prime, map.getOrDefault(prime, 0) + 1);
            num /= prime;
        }
        return map;
    }
}
