// Last updated: 9/10/2025, 8:05:46 PM
class Solution {
    public String sortVowels(String s) {
        int[] map = new int[58];
        char[] arr = s.toCharArray();
        int n = arr.length, idx = 0;
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (isVowel(c)) {
                map[c - 'A']++;
                arr[i] = '#';
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i]; j++) {
                list.add((char) (i + 'A'));
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == '#') {
                arr[i] = list.get(idx++);
            }
        }
        return new String(arr);
    }
    private boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U');
    }
}