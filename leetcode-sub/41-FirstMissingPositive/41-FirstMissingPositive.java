// Last updated: 7/30/2025, 5:50:33 PM
class Solution {
    public int firstMissingPositive(int[] nums) {
        cycleSort(nums);
        for (int n : nums) {
            System.out.print(n + ", ");
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
    public static void cycleSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
            swap(arr, i, correctIndex);
            }
            else {
                i++;
            }
        }
    }

    static void swap (int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}