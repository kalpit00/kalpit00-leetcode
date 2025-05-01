// Last updated: 5/1/2025, 2:22:10 AM
class Solution {
    public List<String> letterCasePermutation(String s) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {
                continue;
            }
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                char[] str = curr.toCharArray();
                str[i] = Character.toUpperCase(str[i]);
                queue.offer(new String(str));
                str[i] = Character.toLowerCase(str[i]);
                queue.offer(new String(str));
            }
        }
        return new LinkedList<>(queue);
    }
}