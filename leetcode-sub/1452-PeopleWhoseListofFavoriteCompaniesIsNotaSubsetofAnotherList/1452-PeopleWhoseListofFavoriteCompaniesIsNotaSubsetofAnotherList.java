// Last updated: 7/30/2025, 5:20:54 PM
class Solution {
    public String arrangeWords(String text) {
        String[] words = text.toLowerCase().split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
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