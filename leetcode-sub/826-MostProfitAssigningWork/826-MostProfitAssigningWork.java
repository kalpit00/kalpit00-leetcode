// Last updated: 10/30/2025, 12:56:10 PM
class Solution {
    public List<String> printVertically(String s) {
        int max = 0, n = 0, i = 0;
        for (String word : s.split(" ")) {
            n++;
            max = Math.max(max, word.length());
        }
        char[][] arr = new char[n][max];
        for (String word : s.split(" ")) {
            int j = 0;
            for (j = 0; j < word.length(); j++) {
                arr[i][j] = word.charAt(j);
            }
            for (int k = j; k < max; k++) {
                arr[i][k] = ' ';
            }
            i++;
        }
        List<String> res = new ArrayList<>();
        for (int j = 0; j < max; j++) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                sb.append(arr[k][j]);
            }
            int x = sb.length() - 1;
            while (x >= 0 && arr[x][j] == ' ') {
                sb.deleteCharAt(x);
                x--;
            }
            res.add(sb.toString());
        }
        return res;
    }
}