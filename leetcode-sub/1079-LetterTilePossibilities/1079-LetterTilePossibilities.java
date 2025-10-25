// Last updated: 10/24/2025, 11:06:54 PM
class Solution {
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        List<String> set = new ArrayList<>();
        backtrack(arr, sb, 0, set);
        return set.size();
    }
    private void backtrack(char[] arr, StringBuilder sb, 
    int mask, List<String> set) {
        if (!sb.isEmpty()) {
            set.add(sb.toString());
        }
        for (int i = 0; i < arr.length; i++) {
            if (((mask & (1 << i)) != 0) || (i > 0 && arr[i] == arr[i-1] &&
            (mask & (1 << (i - 1))) == 0)) continue;
            sb.append(arr[i]);
            backtrack(arr, sb, mask | (1 << i), set);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
