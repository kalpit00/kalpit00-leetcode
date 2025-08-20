// Last updated: 8/20/2025, 3:00:16 AM
class Solution {
    public boolean isSubstringPresent(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            String key = rev.charAt(i) + "" + rev.charAt(i + 1);
            set.add(key);
        }
        for (int i = 0; i < s.length() - 1; i++) {
            String key = s.charAt(i) + "" + s.charAt(i + 1);
            if (set.contains(key)) {
                return true;
            }
        }
        return false;
    }
}