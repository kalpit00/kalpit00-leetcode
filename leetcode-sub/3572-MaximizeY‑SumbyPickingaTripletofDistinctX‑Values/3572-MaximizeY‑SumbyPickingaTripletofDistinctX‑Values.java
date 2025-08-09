// Last updated: 8/9/2025, 12:42:21 AM
class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < x.length; i++){
            map.put(x[i], Math.max(map.getOrDefault(x[i], 0), y[i]));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(3,Collections.reverseOrder());
        for(int val : map.values()){
            maxHeap.offer(val);
        }

        if(maxHeap.size() < 3){
            return -1;
        }

        int sum = 0;
        // this garantee ordering
        for (int i = 0; i < 3; i++) {
            sum += maxHeap.poll();
        }

        return sum;
    }
}