// Last updated: 7/30/2025, 12:49:12 AM
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length, k = 0, t = 0, j = 0, idx = 0;
        for (int num : nums) {
            k += num < 0 ? 1 : 0;
        }
        int[] neg = new int[k], pos = new int[n - k];
        for (int num : nums) {
            if (num < 0) {
                neg[t++] = -num;
            }
            else {
                pos[j++] = num;
            }
        }
        radixSort(neg);
        radixSort(pos);
        for (int i = k - 1; i >= 0; i--) {
            nums[idx++] = -neg[i];
        }
        for (int i = 0; i < n - k; i++) {
            nums[idx++] = pos[i];
        }
        return nums;
    }

    private void radixSort(int[] nums) {
        int max = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            digitSort(nums, n, exp);
        }
    }
    private void digitSort(int[] nums, int n, int exp) {
        int[] res = new int[n], map = new int[10];
        for (int i = 0; i < n; i++) {
            int d = (nums[i] / exp) % 10;
            map[d]++;
        }
        for (int i = 1; i < 10; i++) {
            map[i] += map[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int d = (nums[i] / exp) % 10;
            res[map[d] - 1] = nums[i];
            map[d]--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }
}
