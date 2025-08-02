// Last updated: 8/1/2025, 11:24:06 PM
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length, idx = n - 1;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        for (int i = 1; i < n; i += 2) {
            nums[i] = arr[idx--];
        }
        for (int i = 0; i < n; i += 2) {
            nums[i] = arr[idx--];
        }
    }
}