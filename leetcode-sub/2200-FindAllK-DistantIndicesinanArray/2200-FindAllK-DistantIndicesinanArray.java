// Last updated: 6/24/2025, 1:55:28 AM
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length, m = n + 2 * k;
        int[] arr = new int[n + 2 * k];
        for (int i = 0; i < k; i++) {
            arr[i] = -1;
            arr[m - i - 1] = -1;
        }
        for (int i = 0; i < n; i++) {
            arr[i + k] = nums[i];
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= 2 * k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        if (map.containsKey(key)) {
            res.add(0);
        }
        for (int i = 1; i < n; i++) {
            map.put(arr[i - 1], map.get(arr[i - 1]) - 1);
            if (map.get(arr[i - 1]) == 0) {
                map.remove(arr[i - 1]);
            }
            map.put(arr[i + 2 * k], map.getOrDefault(arr[i + 2 * k], 0) + 1);
            if (map.containsKey(key)) {
                res.add(i);
            } 
        }
        return res;
    }
}
