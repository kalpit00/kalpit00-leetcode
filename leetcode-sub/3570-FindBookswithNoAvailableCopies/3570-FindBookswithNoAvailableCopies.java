// Last updated: 7/20/2025, 1:30:46 PM
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int min = 9999;
        for (int num : fronts) {
            if (!set.contains(num)) {
                min = Math.min(min, num);
            }
        }  
        for (int num : backs) {
            if (!set.contains(num)) {
                min = Math.min(min, num);
            }
        }
        return min % 9999;
    }
}