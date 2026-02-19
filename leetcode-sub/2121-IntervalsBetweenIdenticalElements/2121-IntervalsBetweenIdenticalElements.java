// Last updated: 2/19/2026, 3:26:55 AM
class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;

        Map<Integer, List<Integer>> indexMap = new HashMap<>();

        for(int i=0;i<n;i++){
            indexMap.computeIfAbsent(arr[i], k-> new ArrayList<>()).add(i);
        }
        long[] result = new long[n];
        for (List<Integer> indices : indexMap.values()) {
            int k = indices.size();
            long totalSum = 0;
            for (int idx : indices) totalSum += idx;

            long prefixSum = 0;
            for (int i = 0; i < k; i++) {
                int currentIdx = indices.get(i);
                
                long leftSide = (long) i * currentIdx - prefixSum;
                long rightSide = (totalSum - prefixSum - currentIdx) - (long) (k - 1 - i) * currentIdx;
                
                result[currentIdx] = leftSide + rightSide;
                prefixSum += currentIdx;
            }
        }
        return result;
    }
}