// Last updated: 7/25/2025, 12:28:48 PM
class Solution {
    public String getSmallestString(String s) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i++) {
            int left = arr[i - 1] - '0';
            int right = arr[i] - '0';
            if ((left % 2 == right % 2) && (arr[i ] < arr[i-1])) {
                char temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                break;
            }
        }
        return new String(arr);
    }
}
