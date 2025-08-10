// Last updated: 8/10/2025, 1:53:03 AM
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < 10 && count != 6; i++) {
            String guess = words[random.nextInt(words.length)];
            count = master.guess(guess);
            List<String> candidates = new ArrayList<>();
            for (String word : words) {
                if (count == helper(guess, word)) {
                    candidates.add(word);
                }
            }
            words = candidates.toArray(new String[0]);
        }
    }
    private int helper(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */