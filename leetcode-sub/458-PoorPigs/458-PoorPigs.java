// Last updated: 11/6/2025, 5:50:53 AM
class Solution {
    public int expressiveWords(String s, String[] words) {
        char[] arr = s.toCharArray();
        int n = arr.length, count = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = 1; // m = streak length
            char c = arr[i];
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
                m++;
            } // store char and streak length for each group in s in a list
            list.add(new int[]{c - 'a', m});
        }
        for (String word : words) {
            count += helper(word.toCharArray(), list) ? 1 : 0;
        }
        return count;
    }
    private boolean helper(char[] arr, List<int[]> list) {
        int n = arr.length, k = 0;
        for (int i = 0; i < n; i++) {
            int m = 1;
            char c = arr[i];
            while (i < n - 1 && arr[i] == arr[i + 1]) {
                i++;
                m++;
            }
            if (k >= list.size()) {
                return false; // query word has more streaks than s
            }            
            if (c - 'a' != list.get(k)[0]) {
                return false; // chars of streaks dont match
            }
            int len = list.get(k)[1]; // streak lengths dont comply
            if (m != len && (m >= len || len < 3)) {
                return false;
            }
            k++; // use k to count streak groups in every word
        }
        return k == list.size();
    } // each streak group in s must match with query word
}