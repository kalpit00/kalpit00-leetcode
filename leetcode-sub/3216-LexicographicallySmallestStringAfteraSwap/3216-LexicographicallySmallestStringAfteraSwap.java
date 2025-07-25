// Last updated: 7/25/2025, 12:27:19 PM
class Solution {
    public String getSmallestString(String s) {
        String min = s;
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if ((arr[i] - '0') % 2 == (arr[i - 1] - '0') % 2) {
                swap(arr, i - 1, i);
                String str = new String(arr);
                if (str.compareTo(min) < 0) {
                    min = str;
                }
                swap(arr, i - 1, i);
            }
        }
        return min;
    }
    private void swap(char[] arr, int i, int j) {
        char c = arr[i];
        arr[i] = arr[j];
        arr[j] = c;
    }
}