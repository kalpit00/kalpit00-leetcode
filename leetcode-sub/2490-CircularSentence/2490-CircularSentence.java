// Last updated: 8/12/2025, 6:52:07 PM
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        while (n > 2) {
            int maxIndex = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (arr[i] > max) { 
                    max = arr[i];
                    maxIndex = i;
                }
            }
            res.add(maxIndex + 1); // 1-indexed res
            res.add(n);
            reverse(arr, 0, maxIndex);
            reverse(arr, 0, n - 1);
            n--;
        }
        if (n == 2 && arr[0] > arr[1]) {
            res.add(2);
        }
        return res;
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}