// Last updated: 4/10/2025, 12:09:03 PM
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, start = 0, end = n - 1, ans = -1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}