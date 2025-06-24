// Last updated: 6/24/2025, 1:58:30 AM
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length, m = n + 2 * k;
        int[] arr = new int[n + 2 * k];
        for (int i = 0; i < k; i++) {
            arr[i] = 2000;
            arr[m - i - 1] = 2000;
        }
        for (int i = 0; i < n; i++) {
            arr[i + k] = nums[i];
        }
        List<Integer> res = new ArrayList<>();
        int[] map = new int[2001];
        for (int i = 0; i <= 2 * k; i++) {
            map[arr[i]]++;
        }
        if (map[key] > 0) {
            res.add(0);
        }
        for (int i = 1; i < n; i++) {
            map[arr[i - 1]]--;
            map[arr[i + 2 * k]]++;
            if (map[key] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}
