// Last updated: 7/21/2025, 9:29:42 PM
class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        int[] map = new int[10001];
        int n = arr.length, max = 0, left = 0, right = 0, counter = 0, sum = 0;
        while (right < n) {
            if (map[arr[right]] > 0) {
                counter++;
            }
            map[arr[right]]++;
            sum += arr[right];
            right++;
            while (counter > 0) {
                if (map[arr[left]] > 1) {
                    counter--;
                }
                map[arr[left]]--;
                sum -= arr[left];
                left++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}