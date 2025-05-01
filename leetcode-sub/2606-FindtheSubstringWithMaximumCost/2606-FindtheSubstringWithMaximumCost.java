// Last updated: 5/1/2025, 5:57:48 PM
class Solution {
    public int maximumCostSubstring(String s, String chars, int[] vals) {

        int[] costs = new int[26];
        for(int i = 0; i < 26; ++i)
            costs[i] = i + 1;
        
        int len = chars.length();
        for(int i = 0; i < len; ++i){
            costs[chars.charAt(i) - 'a'] = vals[i];
        }

        int maxSum = 0;
        int sum = 0;
        
        char[] cs = s.toCharArray();
        for(char c:cs ){
            sum += costs[c - 'a'];
            maxSum = Math.max(maxSum, sum);
            if(sum < 0)
                sum = 0;
        }

        return maxSum;
    }
}