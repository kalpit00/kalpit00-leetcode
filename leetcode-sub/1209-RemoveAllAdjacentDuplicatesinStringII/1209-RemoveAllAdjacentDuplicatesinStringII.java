// Last updated: 6/16/2025, 4:18:36 PM
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            int count = !stack.isEmpty() && stack.peek().ch == c ? 
            stack.peek().counter + 1 : 1;
            stack.push(new Node(c, count));
            if (count == k) {
                while (!stack.isEmpty() && count > 0) {
                    stack.pop();
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }
        return sb.reverse().toString();
    }
    class Node {
        char ch;
        int counter;
        Node(char ch, int counter) {
            this.ch = ch;
            this.counter = counter;
        }
    }
}