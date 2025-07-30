// Last updated: 7/30/2025, 5:19:45 PM
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        int n = words.length;
        String[][] res = new String[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = new String[]{words[i], String.valueOf(i)};
        }
        Arrays.sort(res, (a, b) -> a[0].length() != b[0].length() ? a[0].length() - b[0].length() : Integer.parseInt(a[1]) - Integer.parseInt(b[1]));
        StringBuilder sb = new StringBuilder();
        for (String[] item : res) {
            String word = item[0];
            if (sb.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
            else {
                sb.append(word);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}