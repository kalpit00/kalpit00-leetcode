// Last updated: 8/6/2026, 12:46:24 AM
class Solution {
    public int firstUniqueFreq(int[] nums) {
        int maxElement = Integer.MIN_VALUE;
        for(int i : nums){
            maxElement = Math.max(maxElement, i);
        }
        int[] numFreq = new int[maxElement+1];
        int[] freqCount = new int[nums.length+1];
        for(int i : nums){
            numFreq[i]++;
        }
        for(int i : numFreq){
            freqCount[i]++;
        }
        for(int i : nums){
            if(freqCount[numFreq[i]] == 1){
                return i;
            }
        }
        return -1;
    }
}