// Last updated: 6/24/2025, 2:41:35 AM
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length, m = n + 2 * k, count = 0;
        int[] arr = new int[m];
        for (int i = 0; i < k; i++) {
            arr[i] = 2000;
            arr[m - i - 1] = 2000;
        }
        for (int i = 0; i < n; i++) {
            arr[i + k] = nums[i];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= 2 * k; i++) {
            count += arr[i] == key ? 1 : 0;
        }
        if (count > 0) {
            res.add(0);
        }
        for (int i = k + 1; i < n + k; i++) {
            count -= arr[i - k - 1] == key ? 1 : 0;
            count += arr[i + k] == key ? 1 : 0;
            if (count > 0) {
                res.add(i - k);
            }
        }
        return res;
    }
}
