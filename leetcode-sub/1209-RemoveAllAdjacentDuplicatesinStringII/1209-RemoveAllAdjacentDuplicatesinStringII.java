// Last updated: 6/16/2025, 4:29:56 PM
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int count = !stack.isEmpty() && stack.peek()[0] == c ? 
            stack.peek()[1] + 1 : 1;
            stack.push(new int[]{c, count});
            if (count == k) {
                while (!stack.isEmpty() && count > 0) {
                    stack.pop();
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) stack.pop()[0]);
        }
        return sb.reverse().toString();
    }
}