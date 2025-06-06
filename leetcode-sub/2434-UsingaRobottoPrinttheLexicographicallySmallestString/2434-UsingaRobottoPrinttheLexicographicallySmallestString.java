// Last updated: 6/5/2025, 9:10:44 PM
class Solution {
    public String robotWithString(String s) {
        if (s == null || s.length() < 1) return "";
        int[] freq = new int[26];
        for (char c: s.toCharArray()) { // first loop
            freq[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(); // the final result
        for (char c: s.toCharArray()) { // second loop
            stack.add(c);
            freq[c - 'a']--;
            while (!stack.isEmpty()) {
                char temp = stack.peek();
                if (hasSmaller(temp, freq)) break; // check if there is a smaller character in the rest of the string compared to top character of the stack
                sb.append(stack.pop());
            }
        }
        return sb.toString();
    }
    
    private boolean hasSmaller(char c, int[] freq) {
        int ind = (int)(c - 'a');
        for (int i = 0; i < ind; i++) {
            if (freq[i] > 0) return true;
        }
        return false;
    }
}