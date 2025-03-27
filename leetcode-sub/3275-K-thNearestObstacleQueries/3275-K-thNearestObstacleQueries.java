// Last updated: 3/26/2025, 11:10:49 PM
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int len = queries.length;
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            int now = Math.abs(queries[i][0]) + Math.abs(queries[i][1]);
            if(pq.size() < k){
                pq.offer(now);
            }else{
                if(pq.peek() > now){
                    pq.poll();
                    pq.offer(now);
                }
            }
            if(pq.size() < k){
                res[i] = -1;
            }else{
                res[i] = pq.peek();
            }
        }
        return res;
    }
}