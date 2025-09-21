// Last updated: 9/21/2025, 1:40:29 AM
class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length, count = 0;
        for (int i = 0; i < k; i++) {
            count += arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' 
            || arr[i] == 'o' || arr[i] == 'u' ? 1 : 0;
        }        
        int max = count;
        for (int i = k; i < n; i++) {
            count += arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' 
            || arr[i] == 'o' || arr[i] == 'u' ? 1 : 0;
            count -= arr[i - k] == 'a' || arr[i - k] == 'e' ||
            arr[i - k] == 'i' || arr[i - k] == 'o' || arr[i - k] == 'u' ? 1 : 0;
            max = Math.max(max, count);
        }
        return max;
    }
}