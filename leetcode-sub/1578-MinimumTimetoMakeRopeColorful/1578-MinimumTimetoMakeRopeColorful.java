// Last updated: 11/2/2025, 9:30:37 PM
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int answer = 0;
        int time = 0;
        for (int i = 0; i < colors.length(); ++i) {
            if (i > 0 && colors.charAt(i) != colors.charAt(i-1)) {
                time = 0;
            }
            answer+= Math.min(neededTime[i], time);
            time = Math.max(neededTime[i], time);
        }
        return answer;
    }
}