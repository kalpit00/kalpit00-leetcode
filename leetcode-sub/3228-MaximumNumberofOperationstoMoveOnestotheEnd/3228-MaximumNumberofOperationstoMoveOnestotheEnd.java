// Last updated: 11/12/2025, 9:13:16 PM
public class Solution {
    public int maxOperations(String s) {
        char[] arr = s.toCharArray();
        int count = 0, n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i] == '1' ? 1 : 0;
            if (arr[i] == '0') {
                while (i < n - 1 && arr[i + 1] == '0') {
                    i++;
                }
                sum += count;                
            }
        }
        return sum;
    }
}