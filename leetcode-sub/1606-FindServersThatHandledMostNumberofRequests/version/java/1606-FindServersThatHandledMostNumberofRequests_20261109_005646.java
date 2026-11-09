// Last updated: 11/9/2026, 12:56:46 AM
1class Solution {
2    record Job(int at, int server) {}  // at: the time its server frees up
3
4    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
5        PriorityQueue<Integer> free = new PriorityQueue<>();  // each free server, keyed by its next turn
6        for (int x = 0; x < k; x++) free.add(x);  // at request 0, server x's next turn is x
7        PriorityQueue<Job> busy = new PriorityQueue<>(Comparator.comparingInt(Job::at));
8
9        int[] handled = new int[k];
10        for (int i = 0; i < arrival.length; i++) {
11            while (!busy.isEmpty() && busy.peek().at() <= arrival[i]) {  // done by the arrival
12                int x = busy.poll().server();
13                free.add(i + Math.floorMod(x - i, k));  // its first turn from i on
14            }
15            if (free.isEmpty()) continue;  // none free: the request is dropped
16            int x = free.poll() % k;
17            busy.add(new Job(arrival[i] + load[i], x));
18            handled[x]++;
19        }
20
21        int most = Arrays.stream(handled).max().getAsInt();
22        return IntStream.range(0, k).filter(x -> handled[x] == most).boxed().toList();
23    }
24}