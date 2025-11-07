// Last updated: 11/7/2025, 4:30:16 PM
class Solution {
  public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
    var visited = new HashSet<Pair<Integer, Integer>>();

    var queue = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
    queue.offer(new int[] {start[0], start[1], 0});

    while (!queue.isEmpty()) {
      var a = queue.poll();
      int x = a[0], y = a[1], cost = a[2];
      var pos = new Pair(x, y);

      if (visited.contains(pos)) continue;

      if (x == target[0] && y == target[1])
        return cost;

      visited.add(pos);

      queue.offer(new int[] {target[0], target[1], cost + Math.abs(target[0] - x) + Math.abs(target[1] - y)});

      for (var r : specialRoads)
        if (!visited.contains(new Pair(r[2], r[3])))
          queue.offer(new int[] {r[2], r[3], Math.abs(r[0] - x) + Math.abs(r[1] - y) + cost + r[4]});

    }
    return -1;
  }
}