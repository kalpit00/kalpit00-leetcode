// Last updated: 4/14/2025, 9:07:55 PM
class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        int n = nums1.length;
        int[] nums = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = map.get(nums1[i]);
        }
        int[] leftTree = new int[n + 1];
        int[] rightTree = new int[n + 1];
        for (int num : nums) {
            update(rightTree, num, 1);
        }
        for (int i = 0; i < n; i++) {
            update(rightTree, nums[i], -1);
            int lessLeft = query(leftTree, nums[i] - 1);
            int lessRight = query(rightTree, nums[i] - 1);
            int greaterRight = (n - i - 1) - lessRight;
            res += (long) lessLeft * greaterRight;
            update(leftTree, nums[i], 1);
        }
        return res;
    }
    private void update(int[] tree, int index, int value) {
        index++;
        while (index < tree.length) {
            tree[index] += value;
            index += index & (-index);
        }
    }
    private int query(int[] tree, int index) {
        index++;
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= index & (-index);
        }
        return sum;
    }
}
