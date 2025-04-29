// Last updated: 4/29/2025, 4:01:30 PM
class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length, count = 0;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        FenwickTree fenwickTree = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            count += i - fenwickTree.query(floor(arr, 2L * nums[i]));
            fenwickTree.update(floor(arr, nums[i]), 1);
        }
        return count;
    }
    private int floor(int[] arr, long target) {
        int n = arr.length, start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] <= target) {
                ans = mid;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return ans;
    }
    class FenwickTree {
        int[] tree;
        int n;

        public FenwickTree(int n) {
            this.n = n;
            this.tree = new int[n + 1];
        }
        public int query(int index) {
            int sum = 0;
            index++;
            while (index > 0) {
                sum += tree[index];
                index -= index & (-index);
            }
            return sum;
        }

        public void update(int index, int val) {
            index++;
            while (index < tree.length) {
                tree[index] += val;
                index += index & (-index);
            }
        }
        public int rangeQuery(int left, int right) {
            int sum = 0;
            left++;
            while (left <= right) {
                sum += tree[right];
                right -= right & (-right);
            }
            return sum;
        }
    }
}