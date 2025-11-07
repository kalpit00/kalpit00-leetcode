// Last updated: 11/7/2025, 4:29:56 PM
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // Step 1: Filter out useless special roads
        List<int[]> filteredRoads = new ArrayList<>();
        for (int[] road : specialRoads) {
            int a = road[0], b = road[1], c = road[2], d = road[3], cost = road[4];
            if (cost < Math.abs(a - c) + Math.abs(b - d)) {
                filteredRoads.add(new int[]{a, b, c, d, cost});
            }
        }

        // Step 2: Initialize distance map and priority queue
        Map<List<Integer>, Integer> dist = new HashMap<>();
        dist.put(Arrays.asList(start[0], start[1]), 0);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        heap.offer(new int[]{0, start[0], start[1]});

        // Step 3: Run Dijkstra's algorithm to find shortest path
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int currdist = curr[0], x = curr[1], y = curr[2];
            for (int[] road : filteredRoads) {
                int a = road[0], b = road[1], c = road[2], d = road[3], cost = road[4];
                if (dist.getOrDefault(Arrays.asList(c, d), Integer.MAX_VALUE) > currdist + Math.abs(x - a) + Math.abs(y - b) + cost) {
                    dist.put(Arrays.asList(c, d), currdist + Math.abs(x - a) + Math.abs(y - b) + cost);
                    heap.offer(new int[]{dist.get(Arrays.asList(c, d)), c, d});
                }
            }
        }

        // Step 4: Compute minimum cost to travel from start to target
        int res = Math.abs(target[0] - start[0]) + Math.abs(target[1] - start[1]);
        for (int[] road : filteredRoads) {
            int a = road[0], b = road[1], c = road[2], d = road[3], cost = road[4];
            res = Math.min(res, dist.getOrDefault(Arrays.asList(c, d), Integer.MAX_VALUE) + Math.abs(target[0] - c) + Math.abs(target[1] - d));
        }

        // Step 5: Return the minimum cost
        return res;
    }
}