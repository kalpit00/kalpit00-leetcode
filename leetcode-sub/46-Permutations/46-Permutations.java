// Last updated: 10/24/2025, 3:17:10 AM
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> arr = listToArray(nums);
        while (!set.contains(arr)) {
            set.add(arr);
            nextPermutation(nums);
            arr = listToArray(nums);
        }
        return new ArrayList<>(set);
    }
    private List<Integer> listToArray(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        return arr;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2, j = n - 1;
        for (i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (j = n - 1; j >= 0; j--) {
            if (nums[j] > nums[i]) {
                break;
            }
        }
        swap(nums, i, j);
        reverse(nums, i + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start, j = end;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}