// Last updated: 9/23/2025, 2:28:15 AM
class Solution {
    public String modifyString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if ((i > 0 && arr[i - 1] == c) || 
                    (i < n - 1 && arr[i + 1] == c)) {
                        continue;
                    }
                    arr[i] = c;
                    break;
                }
            }
        }
        return new String(arr);
    }
}