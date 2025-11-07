// Last updated: 11/7/2025, 4:31:19 PM
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int n = specialRoads.length + 2;

        int[][] roads = new int[n][];
        roads[0] = start;
        for(int i=0; i<n-2; i++){
            roads[i+1] = new int[]{specialRoads[i][2], specialRoads[i][3]};
        }
        roads[n-1] = target;

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // 0 -> start
        // specialRoads
        // n-1 -> end corner

        // node, dist
        PriorityQueue<int[]> pq = new PriorityQueue<>((i, j) -> i[1]-j[1]);
        pq.add(new int[]{0, 0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            if(dist[node] != curr[1]){
                continue;
            }
            for(int i=1; i<n-1; i++){
                if(i == node){
                    continue;
                }
                int[] road = specialRoads[i-1];
                int d = Math.abs(road[0]-road[2]) + Math.abs(road[1]-road[3]);
                if(d <= road[4]){
                    continue;
                }
                int diff = Math.abs(road[0]-roads[node][0]) + Math.abs(road[1]-roads[node][1]) + road[4];
                if(dist[i] > dist[node] + diff){
                    dist[i] = dist[node] + diff;
                    pq.add(new int[]{i, dist[i]});
                }
            }
            int diff = Math.abs(roads[node][0]-target[0]) + Math.abs(roads[node][1]-target[1]);
            if(dist[n-1] > curr[1] + diff){
                dist[n-1] = curr[1]+diff;
            }
        }
        return dist[n-1];
    }
}